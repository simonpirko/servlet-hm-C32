// Тут я все переделал на сервлеты.
// Этот код Коли. Работает через Storage. Он уже не нужен


//package service;

//import entity.User;
//import src.main.java.storage.UserStorage;
//
//public class UserService {
//
//    private UserStorage userStorage = new src.main.java.storage.UserStorage();
//
//    public User authService(String login, String password) {
//        User user = userStorage.getUserByLogin(login);
//        if (user == null) {
//            return null;
//        } else {
//            if (user.getPassword().equals(password)) {
//                return user;
//            } else {
//                return null;
//            }
//        }
//    }
//
//    public String authMessageService(String login, String password) {
//        User user = userStorage.getUserByLogin(login);
//        String message;
//        if (user == null) {
//            message = "User " + login + " not found";
//            return message;
//        } else {
//            if (!user.getPassword().equals(password)) {
//                message = "Password not correct";
//                return message;
//            }
//        }
//        return null;
//    }
//}
