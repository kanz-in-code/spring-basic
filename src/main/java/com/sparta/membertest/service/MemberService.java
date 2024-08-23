package com.sparta.membertest.service;

import com.sparta.membertest.dto.*;
import com.sparta.membertest.entity.Member;
import com.sparta.membertest.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public MemberSaveResponseDto saveMember(MemberSaveRequestDto requestDto){
        Member newMember = new Member(requestDto.getName());
        Member savedMember = memberRepository.save(newMember);

        return new MemberSaveResponseDto(savedMember.getId(),savedMember.getName());
    }

    public List<MemberSimpleResponseDto> getNumbers(){
        List<Member> memberList = memberRepository.findAll();

        List<MemberSimpleResponseDto> dtoList = new ArrayList<>();
        for (Member member : memberList) {
            MemberSimpleResponseDto dto = new MemberSimpleResponseDto(member.getName());
            dtoList.add(dto);
        }
        return dtoList;
    }

    public MemberDetailsResponseDto getMember(Long memberID){
        Member member = memberRepository.findById(memberID).orElseThrow(()-> new NullPointerException("멤버가 없습니다."));

        return new MemberDetailsResponseDto(member.getId(),member.getName());
    }
    @Transactional
    public MemberUpdateResponseDto getMember(Long memberID, MemberUpdateRequestDto requestDto){
        Member member = memberRepository.findById(memberID).orElseThrow(()-> new NullPointerException("멤버가 없습니다."));

        member.update(requestDto.getName());

        return new MemberUpdateResponseDto(member.getId(),member.getName());
    }

    @Transactional
    public void deleteMember(Long memberID){
        Member member = memberRepository.findById(memberID).orElseThrow(()-> new NullPointerException("멤버가 없습니다."));

        memberRepository.delete(member);
    }
}
