class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health;
        int healCount = 0;
        int healCastingTime = bandage[0];
        int healPerSec = bandage[1];
        int bonusHeal = bandage[2];
        int time = 0;
        for (int[] attack : attacks) {
            int attackTime = attack[0];
            int attackDamage = attack[1];
            
            while (time < attackTime) {
                healCount++;
                health += healPerSec;
                if (healCount == healCastingTime) {
                    healCount = 0;
                    health += bonusHeal;
                }
                if (health > maxHealth) {
                    health = maxHealth;
                }
                time++;
            }
            
            health -= attackDamage;
            if (health < 1) {
                return -1;
            }
            time++;
            healCount = 0;
        }
        
        return health;
    }
}