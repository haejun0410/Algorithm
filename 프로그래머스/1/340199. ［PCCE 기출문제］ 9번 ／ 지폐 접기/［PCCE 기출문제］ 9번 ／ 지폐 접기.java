class Solution {
    static private int bill_h;
    static private int bill_w;
    static private int wallet_h;
    static private int wallet_w;
    static private int count = 0;
    public int solution(int[] wallet, int[] bill) {
        bill_h = bill[0];
        bill_w = bill[1];
        wallet_h = wallet[0];
        wallet_w = wallet[1];
        
        for(;;) {
            if (check()) {
                break;
            }
            fold();
        }
        
        return count;
    }
    
    public void fold() {
        if (bill_h < bill_w) {
            bill_w /= 2;
        }
        else {
            bill_h /= 2;
        }
        count++;
    }
    
    public boolean check() {
        if ((bill_w <= wallet_w && bill_h <= wallet_h) || (bill_w <= wallet_h && bill_h <= wallet_w)) {
            return true;
        }
        return false;
    }
}