package Package.Lesson22;

public class PasswordManager {
    private String hash = "5f50dfa5385e66ce46ad8d08a9c9be68";
    private int minLength = 6;
    private int maxLength;
    private String passwordSymbols;
    private int step;
    private int beginWith;
    private int finishTo;
    private int currentLength;

    public PasswordManager(String hash, int minLength, int maxLength, String passwordSymbols, int beginWith, int finishTo) {
        this.hash = hash;
        this.minLength = minLength;
        this.maxLength = maxLength;
        this.passwordSymbols = passwordSymbols;
        this.beginWith = beginWith;
        this.finishTo = finishTo;
    }

//    public String passChecker(String hash, int minLength, int maxLength, String passwordSymbols, int beginWith, int finishTo){
////        for (int i = beginWith; i < finishTo; i++) {
////
////        }
//        while (true){
//
//        }
////        return "";
//    }

//    private String passwordGenerator(String currentP){
//        if(currentP.length() >= currentLength){
////            String md5Hex = DigestUtils
//        }
//    }
}
