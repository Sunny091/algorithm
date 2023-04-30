import java.util.HashMap;
import java.util.Map;

public class HW07_4110056028_2 extends LLK {

    @Override
    public boolean checkLLK(int[][] array) {
        if (array.length < 3) {
            return true; // �p�G�I���ƶq�p��3�A�h�@�w�b�P�@���u�W
        }

        // ���C����I�A�p�⥦�̤������ײv�æs�JHashMap��
        HashMap<Double, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int x1 = array[i][0];
                int y1 = array[i][1];
                int x2 = array[j][0];
                int y2 = array[j][1];
                double slope = (double) (y2 - y1) / (double) (x2 - x1);

                // �p�GHashMap���w�g���F�o�ӱײv�A�h�N�p�ƾ��[1
                if (map.containsKey(slope)) {
                    map.put(slope, map.get(slope) + 1);
                } else {
                    // �p�GHashMap���٨S���o�ӱײv�A�h�s�W�@�ӭp�ƾ�
                    map.put(slope, 1);
                }
            }
        }

        // �p�G������@�ӱײv�������p�ƾ����ȵ����I���`�ƴ�2�A�h��ܦ��T���I�b�P�@���u�W
        for (Map.Entry<Double, Integer> entry : map.entrySet()) {
            if (entry.getValue() == array.length - 2) {
                return true;
            }
        }

        // �p�G�S������@�ӱײv�������p�ƾ����ȵ����I���`�ƴ�2�A�h��ܨS���T���I�b�P�@���u�W
        return false;
    }
}
