import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Animate {

	public Animate() throws IOException {
		DataOutputStream dat = new DataOutputStream(new FileOutputStream(
				"./seq.dat"));
		dat.writeShort(Animation.anims.length);
		for (Animation animation : Animation.anims) {
			if (animation.anIntArray353 == null) {
				dat.writeByte(0);
				continue;
			}
			dat.writeByte(1);
			dat.writeByte((animation.anInt352 == -1 ? 0 : animation.anInt352));
			for (int ii = 0; ii < animation.anInt352; ii++) {
				dat.writeShort(animation.anIntArray353[ii]);
				dat.writeShort(animation.anIntArray354[ii] == -1 ? 65535
						: animation.anIntArray354[ii]);
				dat.writeShort(animation.anIntArray355[ii]);
			}
			if (animation.anInt356 != -1) {
				dat.writeByte(2);
				dat.writeShort(animation.anInt356);
			}
			if (animation.anIntArray357 != null) {
				dat.writeByte(3);
				dat.writeByte((animation.anIntArray357.length - 1));
				for (int ii = 0; ii < animation.anIntArray357.length - 1; ii++) {
					dat.writeByte(animation.anIntArray357[ii]);
				}
			}
			if (animation.aBoolean358) {
				dat.writeByte(4);
			}
			if (animation.anInt359 != 5) {
				dat.writeByte(5);
				dat.writeByte(animation.anInt359);
			}
			if (animation.anInt360 != -1) {
				dat.writeByte(6);
				dat.writeShort(animation.anInt360);
			}
			if (animation.anInt361 != -1) {
				dat.writeByte(7);
				dat.writeShort(animation.anInt361);
			}
			if (animation.anInt362 != 99) {
				dat.writeByte(8);
				dat.writeByte(animation.anInt362);
			}
			if (animation.anInt363 != -1) {
				dat.writeByte(9);
				dat.writeByte(animation.anInt362);
			}
			if (animation.anInt364 != -1) {
				dat.writeByte(10);
				dat.writeByte(animation.anInt362);
			}
			if (animation.anInt365 != 2) {
				dat.writeByte(11);
				dat.writeByte(animation.anInt362);
			}
			dat.writeByte(0);
		}
		dat.close();
	}

}