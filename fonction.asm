;entete
extrn lirent:proc, ecrent:proc
extrn ecrbool:proc
extrn ecrch:proc, ligsuiv:proc
.model SMALL
.586

.CODE
<<<<<<< HEAD
debut:
STARTUPCODE

max: 
=======
>>>>>>> 678325a5e92c2ef7a5f27347bf0cd9fe106ae46b

max: 

<<<<<<< HEAD
;ouvbloc 6enter 6,0
=======

;ouvbloc 6
enter 6,0
>>>>>>> 678325a5e92c2ef7a5f27347bf0cd9fe106ae46b

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


;ireturn 8
pop ax
mov [bp+8], ax


;goto FSI1
jmp FSI1


SINON1:


;ireturn 8
pop ax
mov [bp+8], ax


FSI1:


;fermebloc 4
leave
ret 4
min: 
<<<<<<< HEAD

=======
>>>>>>> 678325a5e92c2ef7a5f27347bf0cd9fe106ae46b

;ouvbloc 0enter 0,0

;ouvbloc 0
enter 0,0

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


;ireturn 8
pop ax
mov [bp+8], ax


;goto FSI2
jmp FSI2


SINON2:


;ireturn 8
pop ax
mov [bp+8], ax


FSI2:


;fermebloc 4
leave
ret 4
sup: 
<<<<<<< HEAD
=======

>>>>>>> 678325a5e92c2ef7a5f27347bf0cd9fe106ae46b

;ouvbloc 0
enter 0,0

;ouvbloc 0enter 0,0

;isup
pop bx 
pop ax 
cmp ax,bx 
jle $+6 
push -1 
jmp $+4 
push 0 


;ireturn 8
pop ax
mov [bp+8], ax


;fermebloc 4
leave
ret 4
<<<<<<< HEAD
main:


;ouvbloc 8enter 8,0
=======


debut:
STARTUPCODE

main:

;ouvbloc 8
enter 8,0
>>>>>>> 678325a5e92c2ef7a5f27347bf0cd9fe106ae46b

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


;reserveRetour
sub sp,2
<<<<<<< HEAD


;iload -4
push word ptr [bp-4]


;iload -2
push word ptr [bp-2]


;call max
call max


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


;reserveRetour
sub sp,2


;iconst 1
push word ptr 1
=======
>>>>>>> 678325a5e92c2ef7a5f27347bf0cd9fe106ae46b


;reserveRetour
sub sp,2


;iload -2
push word ptr [bp-2]


<<<<<<< HEAD
;iload -4
push word ptr [bp-4]


;iconst 5
push word ptr 5


;isub
pop bx 
pop ax 
sub ax,bx
push ax


;call max
call max


;iadd
pop bx 
pop ax 
add ax,bx
push ax


;reserveRetour
sub sp,2


;iload -2
push word ptr [bp-2]


;iconst 2
push word ptr 2


;imul
pop bx 
pop ax 
imul bx
push ax
=======
;reserveRetour
sub sp,2
>>>>>>> 678325a5e92c2ef7a5f27347bf0cd9fe106ae46b


;iload -4
push word ptr [bp-4]


<<<<<<< HEAD
;call min
call min


;call sup
call sup


;istore -8
pop ax 
mov word ptr [bp-8], ax


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
=======
;iconst 5
push word ptr 5
>>>>>>> 678325a5e92c2ef7a5f27347bf0cd9fe106ae46b
