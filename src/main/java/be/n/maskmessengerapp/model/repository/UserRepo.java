package be.n.maskmessengerapp.model.repository;

import be.n.maskmessengerapp.model.datamodel.UUIDID;
import be.n.maskmessengerapp.model.datamodel.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepo {

    /**
     * Insert a user into a database.
     * @param id
     *          ID of the user to be added to the database.
     * @param user
     *          User to be added to the database.
     * @return
     *          If the user is added successfully return 1, else return 0.
     */
    int insertUser(UUID id, User user);

    /**
     * Add a user without an id.
     * @param user
     *          User that will be added to the database.
     * @return
     *          If the user is added successfully return 1, else return 0.
     */
    default int insertUser(User user){
        UUID id = UUID.randomUUID();
        return insertUser(id, user);
    }

    /**
     * Select all the users in the "local database" (in this example the database is a local list, since we don't need more than that to store this data), and return the list with all selected users.
     * @return
     *          A list of all the users in the local database.
     */
    List<User> selectAllUsers();

    /**
     * Returns the user from the database with the given ID.
     * @param id
     *          ID of the user you are looking for in the database.
     * @return
     *          The User with the given ID if it exists.
     */
    Optional<User> selectUserByID(UUIDID id);

    Optional<User> findUserByUserName(String username);


    /**
     * Updates the user with the given ID.
     * @param id
     *          ID of the user that needs to be updated.
     * @param user
     *          New object user with the updated elements
     *          (since this is a small project where user has only a field to learn how this works, there is no point on going through the whole update-each-individual-element-at-a-time process)
     * @return
     */
    int updateUserByID(UUID id, User user);

    /**
     * Delete a user from the database with the given ID.
     * @param id
     *          ID of the user that will be deleted from the database.
     * @return
     *          If the user is deleted successfully return 1, else return 0.
     */
    int deleteUserById(UUIDID id);

}
