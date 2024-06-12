package oumaima_nezha_mehdy.zelda.modele.Univers;

public class MapPossible {

    public static MapInt Layer1 = new MapInt(new int[]{ 102,103,103,103,103,103,103,103,104,13,54,11,12,12,12,12,12,12,12,12,
                                                        101,112,112,112,112,112,112,112,109,13,54,11,12,38,12,12,12,12,12,12,
                                                        101,112,108,111,111,111,111,111,110,13,54,11,12,12,12,71,72,74,75,12,
                                                        101,112,118,114,114,114,114,114,115,13,54,11,12,12,63,12,12,12,12,12,
                                                        101,112,109,12,12,71,72,12,12,13,54,11,12,12,59,60,61,62,12,12,
                                                        101,112,109,12,63,12,12,12,12,13,37,11,12,12,55,56,57,58,12,12,
                                                        100,111,110,12,59,60,61,62,12,13,54,11,12,12,5,6,7,12,12,12,
                                                        113,114,115,12,55,56,57,58,12,13,54,11,12,12,90,10,14,15,12,12,
                                                        116,12,12,12,5,6,7,12,12,13,54,22,17,12,13,54,37,22,17,12,
                                                        23,23,23,23,9,10,14,15,23,24,54,54,22,23,24,54,54,54,22,23,
                                                        54,54,54,54,54,37,54,54,54,54,54,54,54,54,54,54,54,54,54,54,
                                                        54,54,54,54,54,54,0,1,2,54,54,54,0,1,1,1,1,1,1,1,
                                                        33,34,35,36,54,54,11,12,27,2,54,0,28,12,12,12,12,12,12,12,
                                                        54,54,54,54,54,54,11,12,12,13,54,11,12,12,12,12,12,12,12,12,
                                                        1,1,1,1,1,1,28,12,12,13,54,11,12,12,12,12,12,12,12,12},20,15);

    public static MapInt Layer2 = new MapInt(new int[]{ 102,103,103,103,103,103,103,103,104,13,54,11,12,12,12,12,12,69,70,12,
                                                        101,112,112,112,112,112,112,112,109,13,54,11,12,12,12,12,12,68,73,12,
                                                        101,112,108,111,111,111,111,111,110,13,54,11,12,69,70,12,12,12,12,12,
                                                        101,112,109,114,114,114,114,114,114,13,54,11,12,68,63,64,65,66,12,12,
                                                        101,112,109,69,70,71,72,12,12,13,54,11,12,67,59,60,61,62,12,12,
                                                        101,112,109,68,63,64,65,66,12,13,54,11,12,12,55,56,57,58,12,12,
                                                        100,111,110,67,59,60,61,62,12,13,54,11,12,12,5,6,7,8,12,12,
                                                        113,114,115,12,55,56,57,58,12,13,54,11,12,12,9,10,14,15,12,12,
                                                        12,117,12,12,12,6,7,8,12,13,54,22,17,12,13,54,54,22,17,12,
                                                        23,23,23,23,9,10,14,15,23,24,54,54,22,23,24,54,54,54,22,23,
                                                        54,54,54,54,54,54,54,54,54,54,54,54,54,54,54,54,54,54,54,54,
                                                        54,54,54,54,54,54,0,1,2,54,54,54,0,1,1,1,1,1,1,1,
                                                        33,34,35,36,54,54,11,12,27,2,54,0,28,12,12,200,12,12,12,12,
                                                        54,54,54,54,54,54,11,12,12,13,54,11,12,12,12,12,12,12,12,12,
                                                        1,1,1,1,1,1,28,12,12,13,54,11,12,12,12,12,12,12,12,12},20,15);

    public static MapInt collision = new MapInt(new int[]{ 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                                            1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0,
                                                            1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0,
                                                            1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0,
                                                            1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0,
                                                            1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0,
                                                            1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0,
                                                            0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                                            1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                                            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                                            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                                            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                                            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0,
                                                            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                                            0, 0, 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},20,15);

    public static MapInt village2 = new MapInt(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,
                                                        15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29,
                                                        30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44,
                                                        45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59,
                                                        60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74,
                                                        75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89,
                                                        90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104,
                                                        105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119,
                                                        120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134,
                                                        135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149,
                                                        150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164,
                                                        165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179,
                                                        180, 181, 182, 183, 184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 194,
                                                        195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209,
                                                        210, 211, 212, 213, 214, 215, 216, 217, 218, 219, 220, 221, 222, 223, 224,
                                                        225, 226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239,
                                                        240, 241, 242, 243, 244, 245, 246, 247, 248, 249, 250, 251, 252, 253, 254,
                                                        255, 256, 257, 258, 259, 260, 261, 262, 263, 264, 265, 266, 267, 268, 269,
                                                        270, 271, 272, 273, 274, 275, 276, 277, 278, 279, 280, 281, 282, 283, 284,
                                                        285, 286, 287, 288, 289, 290, 291, 292, 293, 294, 295, 296, 297, 298, 299},20,15);


    }
