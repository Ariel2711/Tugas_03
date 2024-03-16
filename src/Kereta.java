public class Kereta {
    // deklarasi variabel dengan modifier private
    private Ticket tickets; // objek Ticket untuk menyimpan tiket-tiket yang dipesan untuk satu kereta
    private String namaKereta; // untuk menyimpan nama kereta
    private int sisaTiket; // untuk mennyimpan sisa tiket kereta KAJJ
    private int jumlahTiket = 0; // untuk menyimpan sudah berapa banyak tiket kereta yang dipesan, default nilai 0

    // constructor default, tanpa parameter, untuk kereta komuter
    public Kereta() {
        tickets = new Ticket(); // insisalisasi tickets
        namaKereta = "komuter"; // otomatis insisalisasi value namaKereta dengan "komuter"
    }

    // constructor overload dengan parameter namaKereta dan jumlahTiket, untuk kereta KAJJ
    public Kereta(String namaKereta, int sisaTiket) {
        tickets = new Ticket(namaKereta, jumlahTiket); // inisialisasi tickets
        this.namaKereta = namaKereta; // inisialisasi value namaKereta, mengambil dari parameter namaKereta
        this.sisaTiket = sisaTiket; // inisialisasi value sisaTiket, mengambil dari parameter jumlahTiket
    }

    // method overload tambahTiket dengan 1 parameter, untuk kereta komuter
    public void tambahTiket(String namaPenumpang){
        // seleksi menggunakan if else, untuk mengecek apakah jumlahTiket kurang dari 1000
        if (jumlahTiket < 1000) {
            // buat array sementara untuk menyimpan nama penumpang dengan length jumlahTiket saat ini ditambah 1
            String[] tempNama = new String[jumlahTiket + 1];
            // copy isi dari array nama penumpang di objek tickets (menggunakan getNamaPenumpang()) ke array tempNama
            System.arraycopy(tickets.getNamaPenumpang(), 0, tempNama, 0, tickets.getNamaPenumpang().length);
            // masukkan nama penumpang baru ke tempNama dengan index jumlahTiket, diambil dari parameter namaPenumpang
            tempNama[jumlahTiket] = namaPenumpang;
            // lalu ganti nilai array nama penumpang di objek tickets dengan array tempNama menggunakan setNamaPenumpang()
            tickets.setNamaPenumpang(tempNama);
            // increment variabel jumlahTiket
            jumlahTiket++;
            // menampilkan pesan tiket berhasil dipesan
            System.out.println("================================");
            System.out.println("Tiket berhasil dipesan");
        } else {
            // jika tiket yang dipesan sudah mencapai 1000, akan menampilkan pesan sebagai berikut
            System.out.println("================================");
            System.out.println("Kereta telah habis dipesan, silahkan cari jadwal keberangkatan lainnya");
        }
    }

    // method overload tambahTiket dengan 3 parameter, untuk kereta KAJJ
    public void tambahTiket(String namaPenumpang, String asal, String tujuan) {
        // seleksi menggunakan if else, untuk mengecek apakah jumlahTiket kurang dari sisaTiket
        if (jumlahTiket < sisaTiket) {
            // buat array sementara untuk menyimpan nama penumpang dengan length jumlahTiket saat ini ditambah 1
            String[] tempNama = new String[jumlahTiket + 1];
            // copy isi dari array nama penumpang di objek tickets (menggunakan getNamaPenumpang()) ke array tempNama
            System.arraycopy(tickets.getNamaPenumpang(), 0, tempNama, 0, tickets.getNamaPenumpang().length);
            // masukkan nama penumpang baru ke tempNama dengan index jumlahTiket, diambil dari parameter namaPenumpang
            tempNama[jumlahTiket] = namaPenumpang;
             // lalu ganti nilai array nama penumpang di objek tickets dengan array tempNama menggunakan setNamaPenumpang()
            tickets.setNamaPenumpang(tempNama);
            // buat array sementara untuk menyimpan asal penumpang dengan length jumlahTiket saat ini ditambah 1
            String[] tempAsal = new String[jumlahTiket + 1];
            // copy isi dari array asal penumpang di objek tickets (menggunakan getAsal()) ke array tempAsal
            System.arraycopy(tickets.getAsal(), 0, tempAsal, 0, tickets.getAsal().length);
            // masukkan asal penumpang baru ke tempAsal dengan index jumlahTiket, diambil dari parameter asal
            tempAsal[jumlahTiket] = asal;
             // lalu ganti nilai array asal penumpang di objek tickets dengan array tempAsal menggunakan setAsal()
            tickets.setAsal(tempAsal);
            // buat array sementara untuk menyimpan tujuan penumpang dengan length jumlahTiket saat ini ditambah 1
            String[] tempTujuan = new String[jumlahTiket + 1];
            // copy isi dari array tujuan penumpang di objek tickets (menggunakan getTujuan()) ke array tempTujuan
            System.arraycopy(tickets.getTujuan(), 0, tempTujuan, 0, tickets.getTujuan().length);
            // masukkan tujuan penumpang baru ke tempTujuan dengan index jumlahTiket, diambil dari parameter tujuan
            tempTujuan[jumlahTiket] = tujuan;
             // lalu ganti nilai array tujuan penumpang di objek tickets dengan array tempTujuan menggunakan setTujuan()
            tickets.setTujuan(tempTujuan);
            // increment variabel jumlahTiket
            jumlahTiket++;
            // menampilkan pesan tiket berhasil dipesan, menggunakan if else untuk mengecek apakah sisa tiket kurang dari 30, nilainya diambil dari sisaTiket - jumlahTiket, apabila true menampilkan pesan tambahan berupa brapa sisa tiketnya
            System.out.println("================================");
            System.out.println((sisaTiket - jumlahTiket) < 30 ? ("Tiket berhasil dipesan Sisa tiket tersedia: " + (sisaTiket - jumlahTiket)) : "Tiket berhasil dipesan");
        } else {
            // jika jumlah tiket yang dipesan sudah mencapai sisa tiket, akan menampilkan pesan sebagai berikut
            System.out.println("================================");
            System.out.println("Kereta telah habis dipesan, silahkan cari jadwal keberangkatan lainnya");
        }
    }

    // method untuk menampilkan detail semua tiket yang sudah dipesan
    public void tampilkanTiket() {
        // menampilkan nama kereta
        System.out.println("================================");
        System.out.println("Daftar penumpang kereta api " + namaKereta + ":");
        System.out.println("--------------------------------");
        // looping sebanyak jumlah tiket yang sudah dipesan (diambil dari jumlahTiket) menggunakan for
        for (int i = 0; i < jumlahTiket; i++) {
            // mennguanakan if else untuk menngecek apakah kereta termasuk komuter atau KAJJ dengan melihat nama kereta
            if (namaKereta.equals("komuter")) {
                // print semua nama penumpang, diambil dari getNamaPenumpang() dengan index i
                System.out.println("Nama: " + tickets.getNamaPenumpang()[i]);
            } else {
                // print semua nama penumpang, diambil dari getNamaPenumpang() dengan index i
                System.out.println("Nama: " + tickets.getNamaPenumpang()[i]);
                // print semua asal penumpang, diambil dari getAsal() dengan index i
                System.out.println("Asal: " + tickets.getAsal()[i]);
                // print semua tujuan penumpang, diambil dari getTujuan() dengan index i
                System.out.println("Tujuan: " + tickets.getTujuan()[i]);
                System.out.println("--------------------------------");
            }
        }
    }
}


// old code
// public class Kereta {
//     private Ticket[] listTickets;
//     private String namaKereta;
//     private int sisaTiket;
//     private int jumlahTiket = 0;

//     public Kereta(){
//         listTickets = new Ticket[100];
//         namaKereta = "komuter";
//     }

//     public Kereta(String namaKereta, int jumlahTiket) {
//         listTickets = new Ticket[jumlahTiket];
//         this.namaKereta = namaKereta;
//         this.sisaTiket = jumlahTiket;
//     }

//     public void tambahTiket(String namaPenumpang){
//         if(jumlahTiket < 100){
//             Ticket tiket = new Ticket(namaKereta,1);
//             String[] listNamaPenumpang = {namaPenumpang}; 
//             tiket.setNamaPenumpang(listNamaPenumpang);
//             listTickets[jumlahTiket] = tiket;
//             jumlahTiket++;
//             System.out.println("================================");
//             System.out.println("Tiket berhasil dipesan");
//         }else{
//             System.out.println("================================");
//             System.out.println("Kereta telah habis dipesan, silahkan cari jadwal keberangkatan lainnya");
//         }
//     }

//     public void tambahTiket(String namaPenumpang, String asal, String tujuan){
//         if(jumlahTiket < sisaTiket){
//             Ticket tiket = new Ticket(namaKereta, 1);
//             String[] listNamaPenumpang = {namaPenumpang}; 
//             tiket.setNamaPenumpang(listNamaPenumpang);
//             String[] listAsal = {asal}; 
//             tiket.setAsal(listAsal);
//             String[] listTujuan = {tujuan}; 
//             tiket.setTujuan(listTujuan);
//             listTickets[jumlahTiket] = tiket;
//             jumlahTiket++;
//             System.out.println("================================");
//             System.out.println((sisaTiket - jumlahTiket) < 30 ? ("Tiket berhasil dipesan Sisa tiket tersedia: " + (sisaTiket - jumlahTiket)) : "Tiket berhasil dipesan");
//         }else{
//             System.out.println("================================");
//             System.out.println("Kereta telah habis dipesan, silahkan cari jadwal keberangkatan lainnya");
//         }
//     }

//     public void tampilkanTiket(){
//         System.out.println("================================");
//         System.out.println("Daftar penumpang kereta api " + namaKereta + ":");
//         System.out.println("--------------------------------");
//         for(int i = 0; i < jumlahTiket; i++){
//             if(namaKereta.equals("komuter")){
//                 System.out.println("Nama: "+ listTickets[i].getNamaPenumpang()[0]);
//             }else{
//                 System.out.println("Nama: "+ listTickets[i].getNamaPenumpang()[0]);
//                 System.out.println("Asal: "+ listTickets[i].getAsal()[0]);
//                 System.out.println("Tujuan: "+ listTickets[i].getTujuan()[0]);
//                 System.out.println("--------------------------------");
//             }
//         }
//     }
// }