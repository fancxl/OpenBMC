#ifndef INFINEON_VR_UPDATE_H
#define INFINEON_VR_UPDATE_H

#define FILEPATHSIZE 64
#define MAXBUFFERSIZE 255
#define LENGTHOFBLOCK 4
#define MINOTPSIZE 6000
#define MINWAITTIME 2000
#define MAXWAITTIME 500000
#define MINARGS 4

/* Applicable Digital Controllers */
#define PART1 0x95
#define PART2 0x96
#define PART3 0x97
#define PART4 0x98
#define PART5 0x99

/* CMD PREFIX */
#define RPTR 0xce
#define MFR_REG_WRITE 0xde
#define MFR_REG_READ 0xdf
#define BLOCK_PREFIX 0xfd
#define BYTE_PREFIX 0xfe

/* BYTE DATA */
#define AVAIL_SPACE_BYTE 0x10
#define UPLOAD_BYTE 0x11
#define INVAL_BYTE 0x12

/* DEVICE DISCOVERY BLOCK DATA (DDBD) */
#define DDBD0 0x8c
#define DDBD1 0x00
#define DDBD2 0x00
#define DDBD3 0x70

/* SCRATCHPAD BLOCK DATA (SPBD) */
#define SPBD0 0x00
#define SPBD1 0xe0
#define SPBD2 0x05
#define SPBD3 0x20

#endif