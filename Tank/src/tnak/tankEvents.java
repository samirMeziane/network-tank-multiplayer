package tnak;

import java.util.ArrayList;

import tnakClient.shoot;

public interface tankEvents {
public void userDamaged();
public void userMoved();
public void chatMessageSent(String from, String to,String message);
public void userDead();
public void listPositionChanged();
public void hasRegistred(ArrayList<Position> po);
public void hasShoted(ArrayList<shoot> p) ;


	

}
