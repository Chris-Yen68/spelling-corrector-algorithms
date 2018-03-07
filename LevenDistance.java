/**
 * Created by jeanlee on 2017/9/29.
 */
public class LevenDistance {

    public LevenDistance() {

    }

    public int getMin(int a, int b, int c){
        int min = a;
        if (b < min){
            min = b;
        }
        if (c < min){
            min = c;
        }
        return min;
    }

    public int getDistance(String firstS, String secondS){
        int distance[][];
        int length1 = firstS.length();
        int length2 = secondS.length();
        int value;

        if (length1 == 0){
            return length2;
        }
        if (length2 == 0){
            return length1;
        }

        distance =  new int[length1 + 1][length2 + 1];

        for (int i = 0; i <= length1; i++){
            distance[i][0] = i;
        }

        for (int j = 0; j <= length2; j++){
            distance[0][j] = j;
        }


        for (int i = 1 ; i <= length1; i++){
            char f1= firstS.charAt(i - 1);
            String temp = "" + f1;
            for (int j = 1; j <= length2; j++){
                char f2 = secondS.charAt(j - 1);
                String temp2 = "" + f2;
                if (temp.equalsIgnoreCase(temp2)){
                    value = 0;

                }else {
                    value = 1;

                }
                distance[i][j] = getMin(distance[i - 1][j] + 1,distance[i][j - 1] + 1,distance[i - 1][j - 1] + value);
            }
        }

        return distance[length1][length2];

    }

    public static void main(String[] args) {
        LevenDistance levenDistance = new LevenDistance();
        System.out.println(levenDistance.getDistance("Algorithms","algorithms"));
    }
}
