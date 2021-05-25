package com.piggy.bank.resource.mappers;

import com.piggy.bank.repository.models.GroupDM;
import com.piggy.bank.repository.models.MemberDM;
import com.piggy.bank.resource.models.Group;
import com.piggy.bank.resource.models.Member;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-05-26T00:06:15+0530",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.22.0.v20200530-2032, environment: Java 11.0.8 (Oracle Corporation)"
)
public class AppMapperImpl implements AppMapper {

    @Override
    public GroupDM mapGroup2GroupDM(Group group) {
        if ( group == null ) {
            return null;
        }

        GroupDM groupDM = new GroupDM();

        groupDM.setDeposit( group.getDeposit() );
        groupDM.setId( group.getId() );
        groupDM.setName( group.getName() );
        groupDM.setOrganizerid( group.getOrganizerid() );
        groupDM.setRoi( group.getRoi() );

        return groupDM;
    }

    @Override
    public Group mapGroupDM2Group(GroupDM groupDM) {
        if ( groupDM == null ) {
            return null;
        }

        Group group = new Group();

        group.setDeposit( groupDM.getDeposit() );
        group.setId( groupDM.getId() );
        group.setName( groupDM.getName() );
        group.setOrganizerid( groupDM.getOrganizerid() );
        group.setRoi( groupDM.getRoi() );

        return group;
    }

    @Override
    public MemberDM mapMember2MemberDM(Member member) {
        if ( member == null ) {
            return null;
        }

        MemberDM memberDM = new MemberDM();

        memberDM.setAddress( member.getAddress() );
        memberDM.setEmail( member.getEmail() );
        memberDM.setId( member.getId() );
        memberDM.setName( member.getName() );
        memberDM.setPassword( member.getPassword() );

        return memberDM;
    }

    @Override
    public Member mapMemberDM2Member(MemberDM memberDM) {
        if ( memberDM == null ) {
            return null;
        }

        Member member = new Member();

        member.setAddress( memberDM.getAddress() );
        member.setEmail( memberDM.getEmail() );
        member.setId( memberDM.getId() );
        member.setName( memberDM.getName() );
        member.setPassword( memberDM.getPassword() );

        return member;
    }
}
