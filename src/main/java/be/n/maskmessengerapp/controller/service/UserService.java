package be.n.maskmessengerapp.controller.service;

import be.n.maskmessengerapp.model.datamodel.User;
import be.n.maskmessengerapp.model.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserService(@Qualifier("MySQLUserRepo") UserRepo userRepo){
        this.userRepo = userRepo;
    }


    /**
     * Adds a new user to the database.
     * @param user
     *          User to be added to the database.
     * @return
     *          If the user is added successfully to the database return 1, else return 0.
     */
    public int addUser(User user){
        return this.userRepo.insertUser(user);
    }

    /**
     * Returns a list with all the users in the database.
     * @return
     *          A list with all the users in the database.
     */
    public List<User> getAllUsers(){
        return userRepo.selectAllUsers();
    }

    /**
     * Search in the database for a user with the given ID, and if there exists one, return that user.
     * @param id
     *          ID of the user you are looking for.
     * @return
     *          The user with the given ID, if it exists.
     */
    public Optional<User> getUserByID(UUID id){
        return userRepo.selectUserByID(id);
    }

    /**
     * Update the user with the given ID with the data from the given user.
     * @param id
     *          ID of the user that will be updated.
     * @param user
     *          User object with the updated data
     * @return
     *          If the user is updated successfully return 1, else return 0.
     */
    public int updateUser(UUID id, User user){
        return userRepo.updateUserByID(id, user);
    }

    /**
     * Delete the user with the given ID.
     * @param id
     *          ID of the user that needs to be deleted.
     * @return
     *          If the user is deleted successfully return 1, else return 0.
     */
    public int deleteUser(UUID id){
        return userRepo.deleteUserById(id);
    }
}
