	.text
	.globl	main
	.p2align		1
	.type	main,@function
main:
.main_bb0:
	addi	sp, sp, -76
	mv	s1, s0
	addi	s0, sp, 76
	mv	t0, s1
	sw	t0, -12(s0)
	mv	t0, ra
	sw	t0, -16(s0)
	call	Global_init0
	lw	t1, -16(s0)
	mv	ra, t1
	li	t0, 1
	sw	t0, -20(s0)
	lw	t2, -20(s0)
	sw	t2, -8(s0)
	j	.for_condition_bb_bb0

.main_bb1:
	lw	t0, -4(s0)
	sw	t0, -24(s0)
	lw	t1, -24(s0)
	mv	a0, t1
	lw	t1, -12(s0)
	mv	s0, t1
	addi	sp, sp, 76
	ret

.for_condition_bb_bb0:
	lw	t0, -8(s0)
	sw	t0, -28(s0)
	li	t0, 15000
	sw	t0, -32(s0)
	lw	t1, -32(s0)
	lw	t2, -28(s0)
	slt	t0, t1, t2
	sw	t0, -36(s0)
	lw	t1, -36(s0)
	xori	t0, t1, 1
	sw	t0, -36(s0)
	lw	t1, -36(s0)
	bne	t1, zero, .for_body_bb_bb0
	j	.main_bb2

.for_iter_bb_bb0:
	lw	t0, -8(s0)
	sw	t0, -40(s0)
	lw	t1, -40(s0)
	addi	t0, t1, 1
	sw	t0, -44(s0)
	lw	t2, -44(s0)
	sw	t2, -8(s0)
	j	.for_condition_bb_bb0

.for_body_bb_bb0:
	la	t0, b_global0
	sw	t0, -48(s0)
	lw	t1, -48(s0)
	lw	t0, 0(t1)
	sw	t0, -52(s0)
	lw	t0, -8(s0)
	sw	t0, -56(s0)
	li	t0, 4
	sw	t0, -60(s0)
	lw	t1, -56(s0)
	lw	t2, -60(s0)
	mul	t0, t1, t2
	sw	t0, -64(s0)
	lw	t1, -52(s0)
	lw	t2, -64(s0)
	add	t0, t1, t2
	sw	t0, -68(s0)
	li	t0, 1
	sw	t0, -72(s0)
	lw	t1, -68(s0)
	lw	t2, -72(s0)
	sw	t2, 0(t1)
	j	.for_iter_bb_bb0

.main_bb2:
	li	t0, 0
	sw	t0, -76(s0)
	lw	t2, -76(s0)
	sw	t2, -4(s0)
	j	.main_bb1

	.size	main, .-main
			 # -- End function
	.globl	global_init_N0
	.p2align		1
	.type	global_init_N0,@function
global_init_N0:
.N_entry_bb_bb0:
	addi	sp, sp, -12
	mv	s1, s0
	addi	s0, sp, 12
	mv	t0, s1
	sw	t0, -4(s0)
	li	t0, 15000
	sw	t0, -8(s0)
	la	t0, N_global0
	sw	t0, -12(s0)
	lw	t1, -12(s0)
	lw	t2, -8(s0)
	sw	t2, 0(t1)
	j	.N_exit_bb_bb0

.N_exit_bb_bb0:
	lw	t1, -4(s0)
	mv	s0, t1
	addi	sp, sp, 12
	ret

	.size	global_init_N0, .-global_init_N0
			 # -- End function
	.globl	global_init_b0
	.p2align		1
	.type	global_init_b0,@function
global_init_b0:
.b_entry_bb_bb0:
	addi	sp, sp, -40
	mv	s1, s0
	addi	s0, sp, 40
	mv	t0, s1
	sw	t0, -4(s0)
	li	t0, 15001
	sw	t0, -8(s0)
	li	t0, 4
	sw	t0, -12(s0)
	lw	t1, -8(s0)
	lw	t2, -12(s0)
	mul	t0, t1, t2
	sw	t0, -16(s0)
	lw	t1, -16(s0)
	addi	t0, t1, 4
	sw	t0, -20(s0)
	lw	t1, -20(s0)
	mv	a0, t1
	mv	t0, ra
	sw	t0, -24(s0)
	call	_f__malloc0
	lw	t1, -24(s0)
	mv	ra, t1
	mv	t0, a0
	sw	t0, -28(s0)
	li	t0, 15001
	sw	t0, -32(s0)
	lw	t1, -28(s0)
	lw	t2, -32(s0)
	sw	t2, 0(t1)
	lw	t1, -28(s0)
	addi	t0, t1, 4
	sw	t0, -36(s0)
	la	t0, b_global0
	sw	t0, -40(s0)
	lw	t1, -40(s0)
	lw	t2, -36(s0)
	sw	t2, 0(t1)
	j	.b_exit_bb_bb0

.b_exit_bb_bb0:
	lw	t1, -4(s0)
	mv	s0, t1
	addi	sp, sp, 40
	ret

	.size	global_init_b0, .-global_init_b0
			 # -- End function
	.globl	global_init_resultCount0
	.p2align		1
	.type	global_init_resultCount0,@function
global_init_resultCount0:
.resultCount_entry_bb_bb0:
	addi	sp, sp, -12
	mv	s1, s0
	addi	s0, sp, 12
	mv	t0, s1
	sw	t0, -4(s0)
	li	t0, 0
	sw	t0, -8(s0)
	la	t0, resultCount_global0
	sw	t0, -12(s0)
	lw	t1, -12(s0)
	lw	t2, -8(s0)
	sw	t2, 0(t1)
	j	.resultCount_exit_bb_bb0

.resultCount_exit_bb_bb0:
	lw	t1, -4(s0)
	mv	s0, t1
	addi	sp, sp, 12
	ret

	.size	global_init_resultCount0, .-global_init_resultCount0
			 # -- End function
	.globl	Global_init0
	.p2align		1
	.type	Global_init0,@function
Global_init0:
.global_all_bb_bb0:
	addi	sp, sp, -16
	mv	s1, s0
	addi	s0, sp, 16
	mv	t0, s1
	sw	t0, -4(s0)
	mv	t0, ra
	sw	t0, -8(s0)
	call	global_init_N0
	lw	t1, -8(s0)
	mv	ra, t1
	mv	t0, ra
	sw	t0, -12(s0)
	call	global_init_b0
	lw	t1, -12(s0)
	mv	ra, t1
	mv	t0, ra
	sw	t0, -16(s0)
	call	global_init_resultCount0
	lw	t1, -16(s0)
	mv	ra, t1
	lw	t1, -4(s0)
	mv	s0, t1
	addi	sp, sp, 16
	ret

	.size	Global_init0, .-Global_init0
			 # -- End function
	.type	N_global0,@object
	.section	.bss
	.globl	N_global0
N_global0:
	.word	0
	.size	N_global0, 4
	.type	b_global0,@object
	.section	.bss
	.globl	b_global0
b_global0:
	.word	0
	.size	b_global0, 4
	.type	resultCount_global0,@object
	.section	.bss
	.globl	resultCount_global0
resultCount_global0:
	.word	0
	.size	resultCount_global0, 4

