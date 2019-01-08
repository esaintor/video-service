package mn.saga.vstream.services;

import mn.saga.vstream.models.Users;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {

    // all
    List<Users> findAll();
    // paging all
    Page<Users> findAll(int pageNumber, int pageSize, String field);

}
