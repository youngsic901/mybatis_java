package pack;

import java.util.List;

public class MyBatisMain {
    public static void main(String[] args) {
        ProcessDao processDao = ProcessDao.getInstance();

        try {
            System.out.println("전체 자료 출력 --------------");
            List<DataDto> list = processDao.selectDataAll();
            for(DataDto s : list) {
                System.out.println(s.getCode() + " " + s.getSang() + " " + s.getSu() + " " + s.getDan());
            }

            System.out.println("부분 자료 출력 --------------");
            String code = "9";
            DataDto dto = processDao.selectDataPart(code);
            System.out.println(dto.getCode() + " " + dto.getSang() + " " + dto.getSu() + " " + dto.getDan());

            System.out.println("자료 추가 --------------");
            DataBean dataBean = new DataBean();
            dataBean.setCode("11");
            dataBean.setSang("카푸치노");
            dataBean.setSu("20");
            dataBean.setDan("5000");
            processDao.insData(dataBean);

            list = processDao.selectDataAll();
            for(DataDto s : list) {
                System.out.println(s.getCode() + " " + s.getSang() + " " + s.getSu() + " " + s.getDan());
            }

            System.out.println("자료 수정 --------------");
            dataBean.setCode("11");
            dataBean.setSang("커피");
            dataBean.setSu("100");
            dataBean.setDan("10000");
            processDao.upData(dataBean);

            list = processDao.selectDataAll();
            for(DataDto s : list) {
                System.out.println(s.getCode() + " " + s.getSang() + " " + s.getSu() + " " + s.getDan());
            }

            System.out.println("자료 삭제 --------------");
            boolean b = processDao.delData(11);
            if(b){
                System.out.println("삭제 성공");
            } else {
                System.out.println("삭제 실패");
            }
            list = processDao.selectDataAll();
            for(DataDto s : list) {
                System.out.println(s.getCode() + " " + s.getSang() + " " + s.getSu() + " " + s.getDan());
            }

        } catch (Exception e) {
            System.out.println("err : " + e);
        }
    }
}
