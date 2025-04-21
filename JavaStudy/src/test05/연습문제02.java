//package test05;
//
//public class 연습문제02 {
//    public static void main(String[] args) {
////        WrongPasswordException도 따로 만들어줘야함
//        연습문제02 e = new 연습문제02();
//        try{
//            e.login("white", 1234);
//        }catch (NotExistIdException ex){
//            throw new RuntimeException(ex);
//        }catch (WrongPasswordException ex){
//            throw new RuntimeException(ex);
//        }
//
//        try{
//            e.login("we", 12324);
//        }catch (NotExistIdException ex){
//            throw new RuntimeException(ex);
//        }catch (WrongPasswordException ex){
//            throw new RuntimeException(ex);
//        }
//
//
//
//
//    }
//    public void login(String id, int pw)
//            throws NotExistIdException,WrongPasswordException{
//        if(!id.equals("blue")) {
//            throw new NotExistIdException("아이디없음");
//        }
//        if(pw != 6) {
//            throw new WrongPasswordException("비밀틀림");
//        }
//    }
//}
