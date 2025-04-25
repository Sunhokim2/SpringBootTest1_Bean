package org.example.basic.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.example.basic.dto.PlayerDTO;
import org.example.basic.dto.TeamDTO;
import org.example.basic.entity.AssemblyMember;
import org.example.basic.entity.Player;
import org.example.basic.entity.ServiceCenter;
import org.example.basic.entity.Team;
import org.example.basic.respository.AssemblyMemberRepository;
import org.example.basic.respository.PlayerRepository;
import org.example.basic.respository.ServiceCenterRepository;
import org.example.basic.respository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JpaController {
    @Autowired
    ServiceCenterRepository serviceCenterRepository;
    @Autowired
    AssemblyMemberRepository amr;
    @Autowired
    TeamRepository tmr;
    @Autowired
    PlayerRepository pr;

    /**
     * DTO 사용하는 이유 :
     * * 1. DTO를 사용하면 데이터 전송 시 필요한 필드만 포함할 수 있어 보안과 성능을 향상시킬 수 있습니다.
     * * 2. DTO는 엔티티와 분리되어 있어, 엔티티의 변경이 DTO에 영향을 미치지 않도록 할 수 있습니다.
     * * 3. DTO는 API의 버전 관리를 용이하게 해줍니다.
     * 
     * 또한 이렇게하면 Entity를 그냥 리턴시키는 것보다 효율적으로 데이터전달이가능하다.
     * 이러면 players는 자동적으로 null이 전달된다.
     * 
     * @return
     */
    @GetMapping("/team")
    @ResponseBody
    public List<TeamDTO> getTeam() {
        List<Team> teams = tmr.findAll();
        List<TeamDTO> list = teams.stream().map((team) -> {
            TeamDTO dto = new TeamDTO();
            dto.setTeamId(team.getTeamId());
            dto.setTeamName(team.getTeamName());

            List<Player> ps = team.getPlayers();
            List<PlayerDTO> ps2 = ps.stream().map((player) -> {
                PlayerDTO dto2 = new PlayerDTO();
                dto2.setPlayerId(player.getPlayerId());
                dto2.setPlayerName(player.getPlayerName());
                return dto2;
            }).toList();

            dto.setPlayers(ps2);
            return dto;
        }).toList();
        return list;
    }

    @GetMapping("/player")
    @ResponseBody
    public List<PlayerDTO> getMethodName() {
        List<Player> players = pr.findAll();
        // 메소드 참조 사용
        List<PlayerDTO> list = players.stream().map(Player::toDto).toList();

        /**
         * 
         * // 아래 코드는 Players.java로 이동했습니다.
         * 
         * List<PlayerDTO> list = players.stream().map((player) -> {
         * PlayerDTO dto = new PlayerDTO();
         * dto.setPlayerId(player.getPlayerId());
         * dto.setPlayerName(player.getPlayerName());
         * 
         * // 팀 ID불러오고
         * Team team = player.getTeam();
         * 
         * TeamDTO teamDto = new TeamDTO();
         * teamDto.setTeamId(team.getTeamId());
         * teamDto.setTeamName(team.getTeamName());
         * dto.setTeam(teamDto);
         * 
         * return dto;
         * }).toList();
         */

        return list;
    }

    @GetMapping("/sc/add")
    @ResponseBody
    public ServiceCenter scAdd(
            @ModelAttribute ServiceCenter sc) {

        LocalDateTime now = LocalDateTime.now();
        sc.setPurDate(now);

        ServiceCenter result = serviceCenterRepository.save(sc);
        return result;

    }

    @GetMapping("/sc/list")
    @ResponseBody
    public List<ServiceCenter> scList() {
        List<ServiceCenter> list = serviceCenterRepository.findAll();
        return list;
    }

    @GetMapping("/sc/modify")
    @ResponseBody
    public ServiceCenter scModify(
            @ModelAttribute ServiceCenter sc) {
        // 수정으 ㄹ위해 DB의 데이터를 조회
        Optional<ServiceCenter> optional = serviceCenterRepository.findById(sc.getId());

        // 퍼데이트는 이전꺼 그대로 사용
        ServiceCenter savedSc = optional.get();
        sc.setPurDate(savedSc.getPurDate());
        ServiceCenter result = serviceCenterRepository.save(sc);
        return result;
    }

    // 어셈블리멤버 entity 사용
    /**
     * 페이징 사용
     * 
     * @param page
     * @param count
     * @return
     */
    @GetMapping("/assembly_member")
    @ResponseBody
    public List<AssemblyMember> assemblyMember(
            @RequestParam(defaultValue = "1") Integer page, // 페이지 번호 (기본값 1)
            @RequestParam(defaultValue = "10") Integer count // 페이지당 데이터 개수 (기본값 10)
    ) {
        Order order = Order.desc("id");
        Sort sort = Sort.by(order); // 정렬 기준 설정
        // 페이징 처리 (data.domain.Pageable)
        Pageable pagable = PageRequest.of(page - 1, count, sort); // 페이지 번호 0, 페이지당 10개

        // 페이지(data.domain.Page)로 조회
        Page<AssemblyMember> list = amr.findAll(pagable);
        return list.getContent();
    }

}
