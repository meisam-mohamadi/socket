import java.util.ArrayList;
import java.util.List;

public class CommandConverter {
    /**
     * @param command     dastoore beine * va hex e akhar
     * @param lastHexCode hex bad az command
     * @return
     */
    public byte[] commandToByteArray(String command, int lastHexCode) {
        List<Byte> bytesList = new ArrayList<>();
        String[] str = {"*", command};
        for (String item : str) {
            byte[] bytes = item.getBytes();
            for (byte i : bytes) {
                bytesList.add(i);
            }
        }
        bytesList.add((byte) lastHexCode);

        byte[] result = new byte[bytesList.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = bytesList.get(i);
        }
        return result;
    }

}
