import java.util.ArrayList;
import java.util.List;

class DiamondPrinter {

    public static List<String> printToList(char stop_letter) {
        List<String> diamond = new ArrayList<>();
        int letter_A_code = 65;
        int size = (int)stop_letter - letter_A_code;
        int mid_right = size;
        int mid_left = size;
        size = size * 2;

        int increment = letter_A_code;

        for (int row = 0; row <= size; row++) {

            StringBuilder builder = new StringBuilder();

            for (int string_index = 0 ; string_index <= size ; string_index++) {

                if(string_index == mid_right || string_index == mid_left) {
                    builder.append((char)(increment));
                }

                else{
                    builder.append(' ');
                }
            }

            if(row<size/2)
            {
                mid_left--;
                mid_right++;
                increment++;
            }
            else{
                mid_left++;
                mid_right--;
                increment--;
            }

            diamond.add(builder.toString());
        }

        return diamond;
    }

}
