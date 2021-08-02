package kg.easy.salonservice.services.impl;

import kg.easy.salonservice.dao.ReserveRepo;
import kg.easy.salonservice.exceptions.NotExistTime;
import kg.easy.salonservice.mappers.ReservesHourMapper;
import kg.easy.salonservice.models.dtos.ReservedHourDto;
import kg.easy.salonservice.models.enitities.ReservedHours;
import kg.easy.salonservice.services.MasterWorkDayService;
import kg.easy.salonservice.services.ReserveService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ReserveServiceImpl implements ReserveService {

    private ReserveRepo reserveRepo;
    private MasterWorkDayService masterWorkDayService;
    @Override
    public ReservedHourDto save(ReservedHourDto reservedHourDto){
        boolean inTime = masterWorkDayService.inTime(reservedHourDto.getMasterWorkDay().getId(),reservedHourDto.getStartTime(),reservedHourDto.getEndTime());
        if (!inTime){
            try {
                throw  new NotExistTime("Не входит в диапозон");
            } catch (NotExistTime notExistTime) {
                notExistTime.printStackTrace();
            }
        }
        List<ReservedHours> reservedHoursList = reserveRepo.findAllByMasterWorkDayId(reservedHourDto.getMasterWorkDay().getId());
        boolean isFreeTime = checkFreeTime(reservedHoursList,reservedHourDto.getStartTime(),reservedHourDto.getEndTime());
        if (isFreeTime){
            throw new RuntimeException("not exist free time");
        }
        ReservedHours reservedHours = ReservesHourMapper.INSTANCE.toReservedHours(reservedHourDto);
        reservedHours = reserveRepo.save(reservedHours);
        return ReservesHourMapper.INSTANCE.toReservedHoursDto(reservedHours);
    }

    private boolean checkFreeTime(List<ReservedHours> reservedHoursList,LocalDateTime startTime,LocalDateTime endTime) {
        return reservedHoursList.stream().anyMatch(x->
                        (x.getStartTime().isBefore(startTime)||x.getStartTime().isAfter(startTime)||x.getStartTime().isEqual(startTime))
                &&
                                (x.getEndTime().isEqual(endTime)||x.getEndTime().isBefore(endTime)||x.getEndTime().isEqual(endTime))
                );
    }

    @Override
    public ReservedHourDto update(ReservedHourDto reservedHourDto) {
        return null;
    }

    @Override
    public ReservedHourDto findById(Long id) {
        return null;
    }

    @Override
    public List<ReservedHourDto> findAll() {
        return null;
    }

    @Override
    public List<ReservedHourDto> findByMasterWorkDayId(Long id) {
        return null;
    }
}
