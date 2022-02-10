package com.datasource;

import com.datasource.entity.member.Member;
import com.datasource.service.read.member.MemberReadService;
import com.datasource.service.write.member.MemberWriteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Optional;

@SpringBootTest
class DatasourceApplicationTests {

	@Autowired
	MemberReadService memberReadService;

	@Autowired
	MemberWriteService memberWriteService;

	@Test
	void 회원_ID가_data_id_1_인_정보_검색() {
		final String id = "data_id_1";

		Member member = Optional.ofNullable(this.memberReadService.findId(id))
				.orElseGet(Member::defaultObj);

		Assert.isTrue(id.equals(member.getId()), "데이터가 존재 하지 않습니다.");
	}

	@Test
	void 회원_ID가_testUser_인_회원_저장() {
		final String id = "testUser";

		Member member = new Member(id, "테스트유저", 42);
		this.memberWriteService.save(member);

		Assert.isTrue(Optional.ofNullable(member.getMemberSeq()).orElse(0L) > 0
				, "데이터가 정상 등록이 되질 않았습니다.");
	}
}
