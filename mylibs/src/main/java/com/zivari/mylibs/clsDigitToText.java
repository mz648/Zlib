package com.zivari.mylibs;

public  class clsDigitToText
{
    private  static String f1(String s)
    {
        String t = "";
        switch (s)
        {
            case "0":
            { t = ""; break; }
            case "1":
            {
                t = "يكصد";
                break;
            }
            case "2":
            {
                t = "دويست";
                break;
            }
            case "3":
            {
                t = "سيصد";
                break;
            }
            case "4":
            {
                t = "چهارصد";
                break;
            }
            case "5":
            {
                t = "پانصد";
                break;
            }
            case "6":
            {
                t = "ششصد";
                break;
            }
            case "7":
            {
                t = "هفتصد";
                break;
            }//www.mspsoft.com بزرگترین منبع پرژه های برنامه نویسی
            case "8":
            {
                t = "هشتصد";
                break;
            }
            case "9":
            {
                t = "نهصد";
                break;
            }
        }

        return t;
    }
    private static  String f2(String s)
    {
        String t = "";
        if (s.length() == 0) return ("");
        if (s.length() == 1) s = "0" + s;

        switch (s)
        {
            case "00":
            { t = ""; break; }

            case "01":
            {
                t = "يك";
                break;
            }

            case "02":
            {
                t = "دو";
                break;
            }

            case "03":
            {
                t = "سه";
                break;
            }

            case "04":
            {
                t = "چهار";
                break;
            }

            case "05"://www.mspsoft.com بزرگترین منبع پرژه های برنامه نویسی
            {
                t = "پنج";
                break;
            }

            case "06":
            {
                t = "شش";
                break;
            }

            case "07":
            {
                t = "هفت";
                break;
            }

            case "08":
            {
                t = "هشت";
                break;
            }

            case "09":
            {
                t = "نه";
                break;
            }

            case "10":
            {
                t = "ده";
                break;
            }

            case "11":
            {
                t = "يازده";
                break;
            }

            case "12":
            {
                t = "دوازده";
                break;
            }

            case "13":
            {
                t = "سيزده";
                break;
            }

            case "14":
            {
                t = "چهارده";
                break;
            }

            case "15":
            {
                t = "پانزده";
                break;
            }

            case "16":
            {
                t = "شانزده";
                break;
            }
            //www.mspsoft.com
            case "17":
            {
                t = "هفده";
                break;
            }

            case "18":
            {
                t = "هجده";
                break;
            }

            case "19":
            {
                t = "نوزده";
                break;
            }


            case "20":
            {
                t = "بيست";
                break;
            }

            case "21":
            {
                t = "بيست و يك";
                break;
            }

            case "22":
            {
                t = "بيست و دو";
                break;
            }

            case "23":
            {
                t = "بيست و سه";
                break;
            }

            case "24":
            {
                t = "بيست و چهار";
                break;
            }

            case "25":
            {
                t = "بيست و پنج";
                break;
            }

            case "26":
            {
                t = "بيست و شش";
                break;
            }

            case "27":
            {
                t = "بيست و هفت";
                break;
            }

            case "28":
            {
                t = "بيست و هشت";
                break;
            }

            case "29":
            {
                t = "بيست و نه";
                break;
            }


            case "30":
            {
                t = "سي";
                break;
            }

            case "31":
            {
                t = "سي و يك";
                break;
            }

            case "32":
            {
                t = "سي و دو";
                break;
            }

            case "33":
            {
                t = "سي و سه";
                break;
            }

            case "34":
            {
                t = "سي و چهار";
                break;
            }

            case "35":
            {
                t = "سي و پنج";
                break;
            }

            case "36":
            {
                t = "سي و شش";
                break;
            }

            case "37":
            {
                t = "سي و هفت";
                break;
            }

            case "38":
            {
                t = "سي و هشت";
                break;
            }

            case "39":
            {
                t = "سي و نه";
                break;
            }


            case "40":
            {
                t = "چهل";
                break;
            }

            case "41":
            {
                t = "چهل و يك";
                break;
            }

            case "42":
            {
                t = "چهل و دو";
                break;
            }

            case "43":
            {
                t = "چهل و سه";
                break;
            }

            case "44":
            {
                t = "چهل و چهار";
                break;
            }

            case "45":
            {
                t = "چهل و پنج";
                break;
            }

            case "46":
            {
                t = "چهل و شش";
                break;
            }

            case "47":
            {
                t = "چهل و هفت";
                break;
            }

            case "48":
            {
                t = "چهل و هشت";
                break;
            }

            case "49":
            {
                t = "چهل و نه";
                break;
            }


            case "50":
            {
                t = "پنجاه";
                break;
            }

            case "51":
            {
                t = "پنجاه و يك";
                break;
            }

            case "52":
            {
                t = "پنجاه و دو";
                break;
            }

            case "53":
            {
                t = "پنجاه و سه";
                break;
            }

            case "54":
            {
                t = "پنجاه و چهار";
                break;
            }

            case "55":
            {
                t = "پنجاه و پنج";
                break;
            }

            case "56":
            {
                t = "پنجاه و شش";
                break;
            }

            case "57":
            {
                t = "پنجاه و هفت";
                break;
            }

            case "58":
            {
                t = "پنجاه و هشت";
                break;
            }

            case "59":
            {
                t = "پنجاه و نه";
                break;
            }


            case "60":
            {
                t = "شصت";
                break;
            }

            case "61":
            {
                t = "شصت و يك";
                break;
            }

            case "62":
            {
                t = "شصت و دو";
                break;
            }

            case "63":
            {
                t = "شصت و سه";
                break;
            }

            case "64":
            {
                t = "شصت و چهار";
                break;
            }

            case "65":
            {
                t = "شصت و پنج";
                break;
            }

            case "66":
            {
                t = "شصت و شش";
                break;
            }

            case "67":
            {
                t = "شصت و هفت";
                break;
            }

            case "68":
            {
                t = "شصت و هشت";
                break;
            }

            case "69":
            {
                t = "شصت و نه";
                break;
            }


            case "70":
            {
                t = "هفتاد";
                break;
            }

            case "71":
            {
                t = "هفتاد و يك";
                break;
            }

            case "72":
            {
                t = "هفتاد و دو";
                break;
            }

            case "73":
            {
                t = "هفتاد و سه";
                break;
            }

            case "74":
            {
                t = "هفتاد و چهار";
                break;
            }

            case "75":
            {
                t = "هفتاد و پنج";
                break;
            }

            case "76":
            {
                t = "هفتاد و شش";
                break;
            }

            case "77":
            {
                t = "هفتاد و هفت";
                break;
            }

            case "78":
            {
                t = "هفتاد و هشت";
                break;
            }

            case "79":
            {
                t = "هفتاد و نه";
                break;
            }


            case "80":
            {
                t = "هشتاد";
                break;
            }

            case "81":
            {
                t = "هشتاد و يك";
                break;
            }

            case "82":
            {
                t = "هشتاد و دو";
                break;
            }

            case "83":
            {
                t = "هشتاد و سه";
                break;
            }

            case "84":
            {
                t = "هشتاد و چهار";
                break;
            }

            case "85":
            {
                t = "هشتاد و پنج";
                break;
            }

            case "86":
            {
                t = "هشتاد و شش";
                break;
            }

            case "87":
            {
                t = "هشتاد و هفت";
                break;
            }

            case "88":
            {
                t = "هشتاد و هشت";
                break;
            }

            case "89":
            {
                t = "هشتاد و نه";
                break;
            }


            case "90":
            {
                t = "نود";
                break;
            }

            case "91":
            {
                t = "نود و يك";
                break;
            }

            case "92":
            {
                t = "نود و دو";
                break;
            }

            case "93":
            {
                t = "نود و سه";
                break;
            }

            case "94":
            {
                t = "نود و چهار";
                break;
            }

            case "95":
            {
                t = "نود و پنج";
                break;
            }

            case "96":
            {
                t = "نود و شش";
                break;
            }

            case "97":
            {
                t = "نود و هفت";
                break;
            }

            case "98":
            {
                t = "نود و هشت";
                break;
            }

            case "99":
            {
                t = "نود و نه";
                break;
            }

        } // switch (s)


        return t;
    }
    private  static String c3d(String s)
    {
        String t = "";
        if (s.length() == 0) return ("");
        if (s.length() == 1) s = "00" + s;
        if (s.length() == 2) s = "0" + s;
        if (s == "000") return ("");

        String haveVa = "";
        if ((!(s.substring(1, 2) == "00")) && (s.substring(0, 1) != "0")) haveVa = " و ";
        t = f1(s.substring(0, 1)) + haveVa + f2(s.substring(1, 2));
        return t;
    }
    public static String digitToText(String s)
    {
        String t = "";
        if (s.length() == 0) return ("");
        if (s.length() == 1) s = "00000000000000" + s;
        if (s.length() == 2) s = "0000000000000" + s;
        if (s.length() == 3) s = "000000000000" + s;
        if (s.length() == 4) s = "00000000000" + s;
        if (s.length() == 5) s = "0000000000" + s;
        if (s.length() == 6) s = "000000000" + s;
        if (s.length() == 7) s = "00000000" + s;
        if (s.length() == 8) s = "0000000" + s;
        if (s.length() == 9) s = "000000" + s;
        if (s.length() == 10) s = "00000" + s;
        if (s.length() == 11) s = "0000" + s;
        if (s.length() == 12) s = "000" + s;
        if (s.length() == 13) s = "00" + s;
        if (s.length() == 14) s = "0" + s;
        if (s == "000000000000000") return ("صفر");



        if (!(s.substring(0, 2) == "000"))
        {
            t = t + c3d((s.substring(0, 2))) + " هزار";
            if (!(s.substring(3, 14) == "000000000000"))
            {
                if (!(s.substring(3, 5) == "000"))
                    t = t + " و";
            }
        }

        if (!(s.substring(3, 5) == "000"))
        {
            t = t + c3d((s.substring(3, 5))) + " ميليارد";
            if (!(s.substring(6, 14) == "000000000")) t = t + " و";
        }
        else
        {
            if (!(s.substring(0, 2) == "000")) t = t + " ميليارد و";
        }

        if (!(s.substring(6, 8) == "000"))
        {
            t = t + c3d((s.substring(6, 8))) + " ميليون";
            if (!(s.substring(9, 14) == "000000")) t = t + " و";
        }

        if (!(s.substring(9, 11) == "000"))
        {
            t = t + c3d((s.substring(9, 11))) + " هزار";
            if (!(s.substring(12, 14) == "000")) t = t + " و";
        }

        if (!(s.substring(12, 14) == "000"))
        {
            t = t + c3d((s.substring(12, 14)));
        }


        return t;
    }
}

