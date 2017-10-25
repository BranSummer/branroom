package org.bran.branroom.dto;

import static org.junit.Assert.*;

import java.util.Vector;

import org.bran.branroom.base.BaseTest;
import org.bran.branroom.entity.User;
import org.junit.Test;

public class ChatMessageTest extends BaseTest {

	@Test
	public void testToJson() {
		ChatMessage cm=new ChatMessage(ChatMessage.TYPE_SYS, new User(), "test", new Vector<User>());
		System.out.println(cm.toJson());
	}

}
