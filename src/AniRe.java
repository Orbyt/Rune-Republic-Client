import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class AniRe {

	public AniRe() throws java.io.IOException {
		DataOutputStream out = new DataOutputStream(new FileOutputStream(
				"./seq.dat"));
		out.writeShort(Animation.anims.length);
		for (Animation animation : Animation.anims) {
			if (animation.anIntArray353 == null) {
				out.writeByte(0);
				continue;
			}
			out.writeByte(1);
			out.writeByte((animation.anInt352 == -1 ? 0 : animation.anInt352));
			for (int index = 0; index < animation.anInt352; index++) {
				out.writeShort(animation.anIntArray353[index]);
				out.writeShort((animation.anIntArray354[index] == -1 ? 65535
						: animation.anIntArray354[index]));
				out.writeShort(animation.anIntArray355[index]);
			}
			if (animation.anInt356 != -1) {
				out.writeByte(2);
				out.writeShort(animation.anInt356);
			}
			if (animation.anIntArray357 != null) {
				out.writeByte(3);
				out.writeByte((animation.anIntArray357.length - 1));
				for (int index = 0; index < (animation.anIntArray357.length - 1); index++)
					out.writeByte(animation.anIntArray357[index]);
			}
			if (animation.aBoolean358)
				out.writeByte(4);
			if (animation.anInt359 != -1) {
				out.writeByte(5);
				out.writeByte(animation.anInt359);
			}
			if (animation.anInt360 != -1) {
				out.writeByte(6);
				out.writeShort(animation.anInt360);
			}
			if (animation.anInt361 != -1) {
				out.writeByte(7);
				out.writeShort(animation.anInt361);
			}
			if (animation.anInt362 != -1) {
				out.writeByte(8);
				out.writeByte(animation.anInt362);
			}
			if (animation.anInt363 != -1) {
				out.writeByte(9);
				out.writeByte(animation.anInt362);
			}
			if (animation.anInt364 != -1) {
				out.writeByte(10);
				out.writeByte(animation.anInt362);
			}
			if (animation.anInt365 != -1) {
				out.writeByte(11);
				out.writeByte(animation.anInt362);
			}
			out.writeByte(0);
		}
		out.close();
	}

}