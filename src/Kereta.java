public class Kereta {
    private Ticket[] listTickets;
    private String namaKereta;
    private int sisaTiket;
    private int jumlahTiket = 0;

    public Kereta(){
        listTickets = new Ticket[100];
        namaKereta = "komuter";
    }

    public Kereta(String namaKereta, int jumlahTiket) {
        listTickets = new Ticket[jumlahTiket];
        this.namaKereta = namaKereta;
        this.sisaTiket = jumlahTiket;
    }

    public void tambahTiket(String namaPenumpang){
        if(jumlahTiket < 100){
            Ticket tiket = new Ticket(namaKereta,1);
            String[] listNamaPenumpang = {namaPenumpang}; 
            tiket.setNamaPenumpang(listNamaPenumpang);
            listTickets[jumlahTiket] = tiket;
            jumlahTiket++;
            System.out.println("================================");
            System.out.println("Tiket berhasil dipesan");
        }else{
            System.out.println("================================");
            System.out.println("Kereta telah habis dipesan, silahkan cari jadwal keberangkatan lainnya");
        }
    }

    public void tambahTiket(String namaPenumpang, String asal, String tujuan){
        if(jumlahTiket < sisaTiket){
            Ticket tiket = new Ticket(namaKereta, 1);
            String[] listNamaPenumpang = {namaPenumpang}; 
            tiket.setNamaPenumpang(listNamaPenumpang);
            String[] listAsal = {asal}; 
            tiket.setAsal(listAsal);
            String[] listTujuan = {tujuan}; 
            tiket.setTujuan(listTujuan);
            listTickets[jumlahTiket] = tiket;
            jumlahTiket++;
            System.out.println("================================");
            System.out.println((sisaTiket - jumlahTiket) < 30 ? ("Tiket berhasil dipesan Sisa tiket tersedia: " + (sisaTiket - jumlahTiket)) : "Tiket berhasil dipesan");
        }else{
            System.out.println("================================");
            System.out.println("Kereta telah habis dipesan, silahkan cari jadwal keberangkatan lainnya");
        }
    }

    public void tampilkanTiket(){
        System.out.println("================================");
        System.out.println("Daftar penumpang kereta api " + namaKereta + ":");
        System.out.println("--------------------------------");
        for(int i = 0; i < jumlahTiket; i++){
            if(namaKereta.equals("komuter")){
                System.out.println("Nama: "+ listTickets[i].getNamaPenumpang()[0]);
            }else{
                System.out.println("Nama: "+ listTickets[i].getNamaPenumpang()[0]);
                System.out.println("Asal: "+ listTickets[i].getAsal()[0]);
                System.out.println("Tujuan: "+ listTickets[i].getTujuan()[0]);
                System.out.println("--------------------------------");
            }
        }
    }
}
