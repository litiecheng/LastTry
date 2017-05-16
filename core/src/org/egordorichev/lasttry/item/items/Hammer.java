package org.egordorichev.lasttry.item.items;


import com.badlogic.gdx.graphics.Texture;
import org.egordorichev.lasttry.Globals;
import org.egordorichev.lasttry.LastTry;
import org.egordorichev.lasttry.item.Rarity;
import org.egordorichev.lasttry.item.block.Block;
import org.egordorichev.lasttry.item.wall.Wall;

public class Hammer extends DigTool {
	public Hammer(short id, String name, Rarity rarity, float baseDamage, int power, int useSpeed, Texture texture) {
		super(id, name, rarity, baseDamage, ToolPower.hammer(power), useSpeed, texture);
	}

	public Hammer(short id, String name, float baseDamage, int power, int useSpeed, Texture texture) {
		this(id, name, Rarity.WHITE, baseDamage, power, useSpeed, texture);
	}

	@Override
	protected boolean onUse() {
		int x = LastTry.getMouseXInWorld() / Block.SIZE;
		int y = LastTry.getMouseYInWorld() / Block.SIZE;

		Wall wall = Globals.world.walls.get(x, y);

		if (wall == null) {
			return false;
		}

		ToolPower power = wall.getRequiredPower();

		if (this.power.isEnoughFor(power)) {
			byte hp = Globals.world.walls.getHP(x, y);

			if (hp > 0) {
				Globals.world.walls.setHP((byte) (hp - 1), x, y);
			}
		}

		return false;
	}
}