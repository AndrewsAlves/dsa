
public class KokoEatingBanana {
    public static void main(String[] args) {
         int[] piles = {980628391,681530205,734313996,168632541};
         int h = 819870953;
         System.out.println(minEatingSpeed(piles, h));
         //System.out.println(kokoEatingTime(piles, 6));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int  avg = 0,max = 0, minSpeed = 0;
        long total = 0;
        for (int i = 0; i < piles.length ; i++) {
            total = total + piles[i];
            if (piles[i] > max) max = piles[i];
        }

        avg = (int)(total / h);
        System.out.println(total + " " + h);
        minSpeed = kokoEatingBinery(piles, avg, max, h);

        return minSpeed;
    }

    public static int kokoEatingBinery(int[] piles, int minSpeed, int maxSpeed, int h) {

        int minS = 0;
        int median = (minSpeed + maxSpeed) / 2;

        System.out.println(minSpeed + " " + maxSpeed);

        if (minSpeed == maxSpeed - 1)  {
            int speed1 = kokoEatingTime(piles, minSpeed);
            if (speed1 > h) return maxSpeed;
            else return minSpeed;
        }

        if (minSpeed == maxSpeed) return minSpeed;

        int speedTaken = kokoEatingTime(piles, median);
        if (speedTaken > h) { 
            minS = kokoEatingBinery(piles, median, maxSpeed, h);
        } else {
            minS = kokoEatingBinery(piles, minSpeed, median, h);
        }


        return minS;
    }

    public static int kokoEatingTime(int[] piles, int speed) {
        int i = 0;
        int totalHours = 0;
        while (i < piles.length) {
            double pi = (double)piles[i], s = (double)speed;
            double rem = Math.ceil(pi/s);
            totalHours = totalHours + (int)rem;
            i++;
        }

        return totalHours;
    }
}
