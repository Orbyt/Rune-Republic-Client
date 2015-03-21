import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Gfx {

	public Gfx() throws IOException {
		DataOutputStream dat = new DataOutputStream(new FileOutputStream(
				"spotanim.dat"));
		dat.writeShort(SpotAnim.cache.length);

		for (SpotAnim gfx : SpotAnim.cache) {
			if (gfx.anIntArray408 == null) {
				dat.writeByte(0);
				continue;
			}
			if (gfx.anInt405 != -1) {
				dat.writeByte(1);
				dat.writeShort(gfx.anInt405);
			}
			if (gfx.anInt406 != -1) {
				dat.writeByte(2);
				dat.writeShort(gfx.anInt406);
			}
			if (gfx.anInt410 != 128) {
				dat.writeByte(4);
				dat.writeShort(gfx.anInt410);
			}
			if (gfx.anInt411 != 128) {
				dat.writeByte(5);
				dat.writeShort(gfx.anInt411);
			}
			if (gfx.anInt412 != -1) {
				dat.writeByte(6);
				dat.writeShort(gfx.anInt412);
			}
			if (gfx.anInt413 != -1) {
				dat.writeByte(7);
				dat.writeByte(gfx.anInt413);
			}
			if (gfx.anInt414 != -1) {
				dat.writeByte(8);
				dat.writeByte(gfx.anInt414);
			}
			for (int i = 0; i < 6; i++) {
				if (gfx.anIntArray408[i] != -1 && gfx.anIntArray409[i] != -1) {
					dat.writeByte(40 + i);
					dat.writeShort(gfx.anIntArray408[i]);
					dat.writeByte(50 + i);
					dat.writeShort(gfx.anIntArray409[i]);
				}
			}
			dat.writeByte(0);
		}
		dat.close();
	}

}