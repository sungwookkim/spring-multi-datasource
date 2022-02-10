package com.datasource.service.read.member;

import com.datasource.entity.member.Member;
import com.datasource.repo.core.member.read.MemberRead;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <pre>
 *     회원 검색 서비스 구현체
 * </pre>
 */
@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
public class MemberReadService {
    private final MemberRead memberReadMapper;

    public MemberReadService(MemberRead memberReadMapper) {
        this.memberReadMapper = memberReadMapper;
    }

    /**
     * <pre>
     *     회원 ID로 회원 검색하는 메서드
     * </pre>
     *
     * @param id
     * @return
     */
    public Member findId(String id) {
        return this.memberReadMapper.findId(id);
    }
}
