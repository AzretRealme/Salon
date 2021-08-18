package first.salon.salonservice.services.impl;

import first.salon.salonservice.dao.ReserveRepo;
import first.salon.salonservice.exceptions.ReservedHourException;
import first.salon.salonservice.mappers.ReservesHourMapper;
import first.salon.salonservice.models.dtos.ReservedHourDto;
import first.salon.salonservice.models.dtos.inputs.ReservedHourInput;
import first.salon.salonservice.models.dtos.responses.ReservedHourDtoResponse;
import first.salon.salonservice.models.dtos.responses.ReservedHourWithMasterName;
import first.salon.salonservice.models.enitities.ReservedHours;
import first.salon.salonservice.services.ClientService;
import first.salon.salonservice.services.MasterWorkDayService;
import first.salon.salonservice.services.ReserveService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ReserveServiceImpl implements ReserveService {

    private ReserveRepo reserveRepo;
    private MasterWorkDayService masterWorkDayService;
    private ClientService clientService;

    public ReservedHourWithMasterName saveCustom(ReservedHourInput reservedHourDto) {
        boolean inTime = masterWorkDayService.inTime(reservedHourDto.getMasterWorkDayId(), reservedHourDto.getStartTime(), reservedHourDto.getEndTime());
        if (!inTime) {

            throw new ReservedHourException("Мастер не работает в этот день");

        }
        List<ReservedHours> reservedHoursList = reserveRepo.findAllByMasterWorkDayId(reservedHourDto.getMasterWorkDayId());
        boolean notFreeTime = checkFreeTime(reservedHoursList, reservedHourDto.getStartTime(), reservedHourDto.getEndTime());
        if (notFreeTime) {
            throw new ReservedHourException("Мастер занят на это время");
        }
        ReservedHourDto reservedHourDto1 = new ReservedHourDto();
        reservedHourDto1.setReserveStatus(reservedHourDto.getReserveStatus());
        System.out.println("actual "+clientService.findById(reservedHourDto.getClientId()));
        reservedHourDto1.setClient(clientService.findById(reservedHourDto.getClientId()));
        System.out.println("client " + reservedHourDto1.getClient());
        reservedHourDto1.setMasterWorkDay(masterWorkDayService.findById(reservedHourDto.getMasterWorkDayId()));
        reservedHourDto1.setStartTime(reservedHourDto.getStartTime());
        reservedHourDto1.setEndTime(reservedHourDto.getEndTime());

        reservedHourDto1 = ReservesHourMapper.INSTANCE.toReservedHoursDto(reserveRepo.save(ReservesHourMapper.INSTANCE.toReservedHours(reservedHourDto1)));

        ReservedHourWithMasterName reservedHourDtoResponse = new ReservedHourWithMasterName();
        reservedHourDtoResponse.setClientId(reservedHourDto1.getClient().getId());
        reservedHourDtoResponse.setMaster(reservedHourDto1.getMasterWorkDay().getMaster());
        reservedHourDtoResponse.setReserveStatus(reservedHourDto1.getReserveStatus());
        reservedHourDtoResponse.setStartTime(reservedHourDto1.getStartTime());
        reservedHourDtoResponse.setEndTime(reservedHourDto1.getEndTime());
        return reservedHourDtoResponse;
    }

    private boolean checkFreeTime(List<ReservedHours> reservedHoursList, LocalDateTime startTime, LocalDateTime endTime) {
        return reservedHoursList.stream().anyMatch(x ->
                (x.getStartTime().isEqual(startTime) || x.getEndTime().isEqual(endTime))
                        ||
                        (x.getStartTime().isBefore(startTime) && x.getEndTime().isAfter(endTime))
                        ||
                        (x.getStartTime().isAfter(startTime) && x.getEndTime().isBefore(endTime))

        );
    }

    @Override
    public ReservedHourDto save(ReservedHourDto reservedHourDto) {
        return null;
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
    public List<ReservedHourDto> findByMasterWorkDayId(Long masterWorkDayId) {
        List<ReservedHours> reservedHoursList = reserveRepo.findAllByMasterWorkDayId(masterWorkDayId);
        return ReservesHourMapper.INSTANCE.toReservedHourDtoList(reservedHoursList);
    }

    public List<ReservedHourDtoResponse> findAllReservedHoursByMasterDayId(Long masterWorkDayId){
        return ReservesHourMapper.INSTANCE.toReservedHourDtoResponse(findByMasterWorkDayId(masterWorkDayId));
    }
}
