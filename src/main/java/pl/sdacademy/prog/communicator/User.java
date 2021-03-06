package pl.sdacademy.prog.communicator;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.Optional;

import static pl.sdacademy.prog.communicator.AppConstants.OUTPUT_DIR;

@ToString(exclude = {"subscribedChannels"})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Slf4j
public class User {
    private String email;
    private String username;
    private List<Channel> subscribedChannels;
    private Communicator communicator;

    public Optional<Channel> subscribe (final String channelName){
        final Optional<Channel> channelOptional = findPublicChannelByName(channelName);
        channelOptional.ifPresent(this::handleChannelSubscription);
        return channelOptional;
    }

    private Optional<Channel> findPublicChannelByName(final String channelName){
        return  communicator.getPublicChannels()
                .stream()
                .filter(existingChannel -> existingChannel.getName().equals(channelName))
                .findFirst();
    }

    private void handleChannelSubscription(final Channel channel){
        channel.subscribe(this);
        subscribedChannels.add(channel);
        final List<String> allExistingMessages = channel.getAllReadableMessages();
        saveMessages(channel.getName(), allExistingMessages, StandardOpenOption.CREATE);
    }

    private void saveMessages(final String channelName, final List<String> messages, final OpenOption openOption){
        try {
            Files.write(getUsersChannelFilePath(channelName),
                    messages, openOption);
        } catch (final IOException exp) {
            log.debug("",exp);
            throw new SlackException("Failed to save messages history for user " + username, exp);
        }
    }

    private void saveMessages(final String channelName, final String message, final OpenOption openOption) {
        saveMessages(channelName, List.of(message), openOption);
    }

    private Path getUsersChannelFilePath(final String channelName){
        return Paths.get(OUTPUT_DIR + "\\" + channelName + "_" + username + ".txt");
    }

    public void sendMessage (final String messageText, final String channelName){
        findPublicChannelByName(channelName)
                .ifPresent(channel -> sendMessage(messageText, channel));
    }

    private void sendMessage (final String messageText, final Channel channel){
        if (!subscribedChannels.contains(channel)) {
            log.info("User tried to send message to channel that was not subscribed to");
            channel.subscribe(this);
        }
        channel.sendMessage(this, messageText);
    }
    public void handleNewMessage(final String channelName, final Message message) {
        saveMessages(channelName, message.getReadable(), StandardOpenOption.APPEND);
    }
}
