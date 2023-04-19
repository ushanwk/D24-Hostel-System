package lk.ijse.hibernate.d24.bo.custom.impl;

import lk.ijse.hibernate.d24.bo.custom.UserBO;
import lk.ijse.hibernate.d24.dto.UserDTO;
import lk.ijse.hibernate.d24.entity.UserEntity;
import lk.ijse.hibernate.d24.repository.RepositoryFactory;
import lk.ijse.hibernate.d24.repository.custom.UserRepository;
import lk.ijse.hibernate.d24.repository.custom.impl.UserRepostoryImpl;

public class UserBOImpl implements UserBO {

    UserRepository userRepository = (UserRepository) RepositoryFactory.getRepositoryFactory().getRepository(RepositoryFactory.RepositoryTypes.USER);
    @Override
    public boolean saveUser(UserDTO userDTO) {
        return userRepository.save(new UserEntity(userDTO.getUserName(), userDTO.getPassword() ,userDTO.getName() ,userDTO.getTel()));
    }

    @Override
    public boolean updateUser(UserDTO userDTO) {
        return userRepository.update(new UserEntity(userDTO.getUserName(), userDTO.getPassword() ,userDTO.getName() ,userDTO.getTel()));

    }

    @Override
    public boolean deleteUser(UserDTO userDTO) {
        return userRepository.delete(new UserEntity(userDTO.getUserName(), userDTO.getPassword() ,userDTO.getName() ,userDTO.getTel()));

    }

    @Override
    public UserDTO searchUser(String id) {
        UserEntity search = userRepository.search(id);

        return new UserDTO(search.getUserName(), search.getPassword(), search.getName(), search.getTel());
    }

    @Override
    public String getPassword(String username) {
        return userRepository.getPassword(username);
    }
}
