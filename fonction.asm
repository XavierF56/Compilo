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


;goto FSI2
jmp FSI2


SINON2:


FSI2:


;ouvrePrinc 0
mov bp,sp
sub sp,0


;isup
pop bx 
pop ax 
cmp ax,bx 
jle $+6 
push -1 
jmp $+4 
push 0 


;ouvrePrinc 8
mov bp,sp
sub sp,8


;iconst 5
push word ptr 5


;istore -2
pop ax 
mov word ptr [bp-2], ax


;lireEnt -4
lea dx,[bp-4]
push dx
call lirent


;aLaLigne
call ligsuiv


;iload -2
push word ptr [bp-2]


;iload -4
push word ptr [bp-4]


;iconst 5
push word ptr 5


;iload -4
push word ptr [bp-4]


;iload -4
push word ptr [bp-4]


;iconst 2
push word ptr 2


;iadd
pop bx 
pop ax 
add ax,bx
push ax


;istore -6
pop ax 
mov word ptr [bp-6], ax


;iconst 1
push word ptr 1


;iload -2
push word ptr [bp-2]


;iload -4
push word ptr [bp-4]


;iconst 5
push word ptr 5


;isub
pop bx 
pop ax 
sub ax,bx
push ax


;iload -4
push word ptr [bp-4]


;iadd
pop bx 
pop ax 
add ax,bx
push ax


;iload -2
push word ptr [bp-2]


;iconst 2
push word ptr 2


;imul
pop bx 
pop ax 
imul bx
push ax


;iload -4
push word ptr [bp-4]


;iload -4
push word ptr [bp-4]


;iload -4
push word ptr [bp-4]


;aLaLigne
call ligsuiv


;iload -6
push word ptr [bp-6]


;ecrireEnt
call ecrent


;aLaLigne
call ligsuiv


;iload -8
push word ptr [bp-8]


;ecrireBool
call ecrbool


;queue
nop
EXITCODE
End debut
