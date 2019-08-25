
package io.lvcore.data;


import io.lvcore.api.service.AutheticationServiceImpl;
import io.lvcore.data.UserDTO;
import io.lvcore.db.model.tables.tables.User;
import io.lvcore.db.model.tables.tables.records.UserRecord;
import org.jooq.DSLContext;
import org.jooq.Record5;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static io.lvcore.db.model.tables.Tables.USER;

@Service
public class UserDBService {
    private static final Logger log = LoggerFactory.getLogger(AutheticationServiceImpl.class);

    @Autowired
    private ModelMapper mapper;

    @Autowired
    DSLContext dsl;

    public UserDTO getUserByEmail(String email) {
        log.debug("Inside getUserByEmail for email" + email);
        Record5 rec=  dsl
                .select(USER.ID, USER.EXTERNAL_ID, USER.NAME, USER.EMAIL, USER.ID_PROVIDER)
                .from(USER)
                .where(USER.EMAIL.equal(email))
                .fetchOne();
        if(rec != null)
                return rec.map(u -> mapper.map(u, UserDTO.class));
        else return null;
    }

    public void insertUser(UserDTO user) {
        log.debug("Inside insertUser for id" + user.getId());
        dsl.insertInto(USER, USER.ID, USER.EXTERNAL_ID, USER.NAME, USER.EMAIL, USER.ID_PROVIDER)
                .values(user.getId(), user.getExternalId(), user.getName(), user.getEmail(), user.getIdProvider())
        .execute();
    }
}

