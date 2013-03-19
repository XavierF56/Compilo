;entete
extrn lirent:proc, ecrent:proc
extrn ecrbool:proc
extrn ecrch:proc, ligsuiv:proc
.model SMALL
.586

.CODE
debut:
STARTUPCODE



;ouvrePrinc 6
mov bp,sp
sub sp,6


;istore -6
pop ax 
mov word ptr [bp-6], ax


;iload -6
push word ptr [bp-6]


;isup
pop bx 
pop ax 
cmp ax,bx 
jle $+6 
push -1 
jmp $+4 
push 0 


;iffaux SINON1
pop ax
cmp ax,0
je SINON1


;iload -6
push word ptr [bp-6]


;goto FSI1
jmp FSI1


SINON1:


FSI1:


;ouvrePrinc 0
mov bp,sp
sub sp,0


;iinf
pop bx 
pop ax 
cmp ax,bx 
jge $+6 
push -1 
jmp $+4 
push 0 


;iffaux SINON2
pop ax
cmp ax,0
je SINON2
