package pl.sdacademy.prog.communicator;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ToString(exclude = {"users"})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Slf4j
public class Channel {
    private String name;
    private String topic;
    private List<User> users;
    private List<Message> messages;
    private boolean isPrivate;

    public void sendMessage (final User user, final String content){
        if(!users.contains(user)){
            log.info("User " + user.getUsername() + " is not on channel " + name + " and message cannot be sent");
            return;
        }
        final Message message = createMessage(content, user.getUsername());
        messages.add(message);
        users.forEach(subscribedUser -> subscribedUser.handleNewMessage(name, message));
    }
    private Message createMessage (final String messageText, final String username){
        return Message.builder()
                .username(username)
                .value(messageText)
                .createdAt(LocalDateTime.now())
                .build();
    }
    public void subscribe (final User user){
        final boolean userWithNameDoesNotExist = users.stream()
                .noneMatch(sub -> sub.getUsername().equals(user.getUsername()));
        if(userWithNameDoesNotExist){
            users.add(user);
        }
    }
    public List<String> getAllReadableMessages(){
        return messages.stream()
                .map(Message::getReadable)
                .collect(Collectors.toList());
    }
}
