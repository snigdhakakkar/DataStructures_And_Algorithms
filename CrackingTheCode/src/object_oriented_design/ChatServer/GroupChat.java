package object_oriented_design.ChatServer;

public class GroupChat extends Conversation {
	
	public void removeParticipant(User user) {
		participants.remove(user);
	}
	
	public void addParticipant(User user) {
		participants.add(user);
	}

}
