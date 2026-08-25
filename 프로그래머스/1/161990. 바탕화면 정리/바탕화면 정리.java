class Solution {
     static class Coord {
        int x;
        int y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }


        public void setTopLeft(int x, int y){
            if(this.x > x) {
                this.x = x;
            }
            if(this.y > y) {
                this.y = y;
            }
        }


        public void setBottomRight(int x, int y){
            if(this.x < x) {
                this.x = x;
            }
            if(this.y < y) {
                this.y = y;
            }
        }

    }

    public static int[] solution(String[] wallpaper) {
        Coord topLeft = new Coord(Integer.MAX_VALUE, Integer.MAX_VALUE);
        Coord bottomRight = new Coord(Integer.MIN_VALUE, Integer.MIN_VALUE);
        for (int i = 0; i < wallpaper.length; i++){
            for (int j = 0; j < wallpaper[i].length(); j++){
                if(wallpaper[i].charAt(j) == '#') {
                     topLeft.setTopLeft(i, j);
                     bottomRight.setBottomRight(i+1, j+1);
                }
            }
        }
        return new int[]{topLeft.x, topLeft.y, bottomRight.x, bottomRight.y};
    }
}