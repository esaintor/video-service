package mn.saga.vstream.services;

import mn.saga.vstream.models.Users;
import mn.saga.vstream.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    // import regular repository
    @Autowired
    UserRepository userRepository;

    // import paging repository
    @Autowired
    PagingAndSortingRepository<Users, Long> pagingRepository;

    @Override
    public List<Users> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Page<Users> findAll(int pageNumber, int pageSize, String field) {
        Sort sort = new Sort(new Sort.Order(Sort.Direction.ASC, field));
        Pageable pageable = new PageRequest(pageNumber, pageSize, sort);
        return pagingRepository.findAll(pageable);
    }

}
