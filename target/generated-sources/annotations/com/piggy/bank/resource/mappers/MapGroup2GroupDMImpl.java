package com.piggy.bank.resource.mappers;

import com.piggy.bank.repository.models.GroupDM;
import com.piggy.bank.resource.models.Group;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-05-23T15:31:16+0530",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.22.0.v20200530-2032, environment: Java 11.0.8 (Oracle Corporation)"
)
public class MapGroup2GroupDMImpl implements MapGroup2GroupDM {

    @Override
    public GroupDM mapGroup2GroupDM(Group source) {
        if ( source == null ) {
            return null;
        }

        GroupDM groupDM = new GroupDM();

        groupDM.setDeposit( source.getDeposit() );
        groupDM.setId( source.getId() );
        groupDM.setName( source.getName() );
        groupDM.setOrganizerid( source.getOrganizerid() );
        groupDM.setRoi( source.getRoi() );

        return groupDM;
    }

    @Override
    public Group mapGroupDM2Group(GroupDM destination) {
        if ( destination == null ) {
            return null;
        }

        Group group = new Group();

        group.setDeposit( destination.getDeposit() );
        group.setId( destination.getId() );
        group.setName( destination.getName() );
        group.setOrganizerid( destination.getOrganizerid() );
        group.setRoi( destination.getRoi() );

        return group;
    }
}
