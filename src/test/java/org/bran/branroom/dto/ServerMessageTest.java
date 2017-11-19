package org.bran.branroom.dto;

import static org.junit.Assert.*;

import java.util.Vector;

import org.bran.branroom.base.BaseTest;
import org.bran.branroom.entity.User;
import org.bran.branroom.enums.MessageType;
import org.junit.Test;

public class ServerMessageTest extends BaseTest {

	@Test
	public void testToJson() {
		ServerMessage cm=new ServerMessage(MessageType.TYPE_SERVER, new User(), "test", new Vector<User>());
		System.out.println(cm.toJson());
	}

}
