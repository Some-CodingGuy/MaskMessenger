package be.n.maskmessengerapp.model.repository;

import be.n.maskmessengerapp.model.datamodel.Message;

public interface MessageRepo {

    /**
     * Insert a new message in the database.
     * @param message
     *          Message to be inserted in the database.
     * @return
     *          If the message is inserted successfully return 1, else return 0.
     */
    int insertMessage(Message message);

}
