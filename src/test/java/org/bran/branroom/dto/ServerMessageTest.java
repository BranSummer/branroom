package org.bran.branroom.dto;

import java.util.HashSet;

import org.bran.branroom.base.BaseTest;
import org.bran.branroom.entity.User;
import org.bran.branroom.enums.MessageType;
import org.junit.Test;

public class ServerMessageTest extends BaseTest {

	@Test
	public void testToJson() {
		ServerMessage cm=new ServerMessage(MessageType.TYPE_SERVER, new User(), "test", new HashSet<User>());
		System.out.println(cm.toJson());
	}

}
