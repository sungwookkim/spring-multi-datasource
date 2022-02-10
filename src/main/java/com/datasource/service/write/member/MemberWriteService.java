package com.datasource.service.write.member;

import com.datasource.entity.member.Member;
import com.datasource.repo.core.member.read.MemberRead;
import com.datasource.repo.core.member.write.MemberWrite;
import com.datasource.service.read.member.MemberReadService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * <pre>
 *     회원 저장, 수정, 삭제 서비스 구현체
 * </pre>
 */
@Service
@Transactional(rollbackFor = {Exception.class})
public class MemberWriteService {
    private final MemberWrite memberWriteMapper;

    public MemberWriteService(MemberWrite memberWriteMapper) {
        this.memberWriteMapper = memberWriteMapper;
    }

    /**
     * <pre>
     *     회원 저장 메서드
     * </pre>
     *
     * @param member
     */
    public void save(Member member) {
        this.memberWriteMapper.save(member);
    }
}
