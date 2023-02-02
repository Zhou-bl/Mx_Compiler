	.text
	.global	main
	.p2align		1
	.type	main,@function
main:
.main_bb0:
	addi	sp, sp, -100
	mv	t0, ra
	sw	t0, -24(s0)
	addi	s0, sp, 100
	mv	t0, s1
	sw	t0, -28(s0)
	mv	t0, s2
	sw	t0, -32(s0)
	mv	t0, s3
	sw	t0, -36(s0)
	mv	t0, s4
	sw	t0, -40(s0)
	mv	t0, s5
	sw	t0, -44(s0)
	mv	t0, s6
	sw	t0, -48(s0)
	mv	t0, s7
	sw	t0, -52(s0)
	mv	t0, s8
	sw	t0, -56(s0)
	mv	t0, s9
	sw	t0, -60(s0)
	mv	t0, s10
	sw	t0, -64(s0)
	mv	t0, s11
	sw	t0, -68(s0)
	li	t0, 1
	sw	t0, -72(s0)
	lw	t2, -72(s0)
	sw	t2, -12(s0)
	li	t0, 2
	sw	t0, -76(s0)
	lw	t2, -76(s0)
	sw	t2, -16(s0)
	lw	t0, -16(s0)
	sw	t0, -80(s0)
	lw	t0, -12(s0)
	sw	t0, -84(s0)
	lw	t1, -84(s0)
	lw	t2, -80(s0)
	add	t0, t1, t1
	sw	t0, -88(s0)
	lw	t1, -88(s0)
	lw	t0, 0(t1)
	sw	t0, -92(s0)
	lw	t2, -92(s0)
	sw	t2, -20(s0)
	li	t0, 0
	sw	t0, -96(s0)
	lw	t2, -96(s0)
	sw	t2, -8(s0)
	j	.main_bb1

.main_bb1:
	lw	t0, -8(s0)
	sw	t0, -100(s0)
	lw	t1, -100(s0)
	mv	a0, t1
	lw	t1, -28(s0)
	mv	s1, t1
	lw	t1, -32(s0)
	mv	s2, t1
	lw	t1, -36(s0)
	mv	s3, t1
	lw	t1, -40(s0)
	mv	s4, t1
	lw	t1, -44(s0)
	mv	s5, t1
	lw	t1, -48(s0)
	mv	s6, t1
	lw	t1, -52(s0)
	mv	s7, t1
	lw	t1, -56(s0)
	mv	s8, t1
	lw	t1, -60(s0)
	mv	s9, t1
	lw	t1, -64(s0)
	mv	s10, t1
	lw	t1, -68(s0)
	mv	s11, t1
	lw	t1, -24(s0)
	mv	ra, t1
	addi	sp, sp, 100
	ret

	.size	main, .-main
			 # -- End function

