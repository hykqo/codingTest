package prorammers.level1;

import java.util.PriorityQueue;

public class Bandaging {

    public static class Attack implements Comparable<Attack>{
        int attackTime;
        int damage;

        public Attack(int[] attacks){
            this.attackTime = attacks[0];
            this.damage = attacks[1];
        }

        @Override
        public int compareTo(Attack o) {
            return this.attackTime - o.attackTime;
        }
    }

    public static int solution(int[] bandage, int health, int[][] attacks) {
        int castingTime = bandage[0];
        int recoveryPerSecond = bandage[1];
        int addRecoveryAmount = bandage[2];
        PriorityQueue<Attack> attacksQueue = new PriorityQueue<>();
        for (int i=0; i<attacks.length; i++) attacksQueue.add(new Attack(attacks[i]));

        int remainingHealth = health; //현재 체력
        int i=0; //시간초
        int healthCast = 0; //회복 캐스팅 사용시간. 캐스팅도중에 공격당하면 0으로 초기화되야함.
        //게임시작 공격이 끝날때까지 반복
        while (!attacksQueue.isEmpty()){
            i++; //1초씩 증가.
            boolean isAttacked = false; //초마다 공격여부 판단.
            boolean isHealth = true; //초마다 회복가능여부 판단.

            //해당 초에 공격했는지 체크.
            Attack peek = attacksQueue.peek();
            if(peek.attackTime == i) isAttacked = true;

            //공격했다면 체력 깍기
            if(isAttacked) {
                Attack poll = attacksQueue.poll();
                remainingHealth -= poll.damage;
                isHealth = false; //공격당했다면 회복 멈춰야함.
            }

            if(isHealth) {
                healthCast++;
                remainingHealth += recoveryPerSecond;
            }else{
                healthCast = 0; //회복캐스팅이 중단되었을 경우 캐스팅 초기화.
            }

            //만약 체력회복 캐스팅이 완료되었다면, 추가체력회복 후 캐스팅 초기화.
            if(healthCast == castingTime) {
                remainingHealth += addRecoveryAmount;
                healthCast = 0;
            }

            //체력회복은 최대체력을 넘을 수 없음.
            if(remainingHealth > health) {
                remainingHealth = health;
            }

            //만약 잔존체력이 0이하라면 죽음
            if(remainingHealth <= 0) {
                remainingHealth = -1;
                break;
            }
        }
        return remainingHealth;
    }

    public static void main(String[] args) {

    }


}
