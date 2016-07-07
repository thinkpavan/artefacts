VERSION 5.00
Object = "{67397AA1-7FB1-11D0-B148-00A0C922E820}#6.0#0"; "MSADODC.OCX"
Begin VB.Form frmStudentReturn 
   BackColor       =   &H00400040&
   Caption         =   "Student Return"
   ClientHeight    =   3195
   ClientLeft      =   60
   ClientTop       =   345
   ClientWidth     =   4680
   LinkTopic       =   "Form2"
   Picture         =   "Form9.frx":0000
   ScaleHeight     =   3195
   ScaleWidth      =   4680
   StartUpPosition =   3  'Windows Default
   WindowState     =   2  'Maximized
   Begin VB.CommandButton cmdBack 
      BackColor       =   &H00E0E0E0&
      Caption         =   "&Back"
      BeginProperty Font 
         Name            =   "Century Gothic"
         Size            =   15.75
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   495
      Left            =   7320
      Style           =   1  'Graphical
      TabIndex        =   17
      Top             =   6960
      Width           =   1215
   End
   Begin VB.CommandButton cmdSave 
      BackColor       =   &H00E0E0E0&
      Caption         =   "&Save"
      BeginProperty Font 
         Name            =   "Century Gothic"
         Size            =   15.75
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   495
      Left            =   5775
      Style           =   1  'Graphical
      TabIndex        =   16
      Top             =   6960
      Width           =   1215
   End
   Begin VB.CommandButton cmdAdd 
      BackColor       =   &H00E0E0E0&
      Caption         =   "&Add"
      BeginProperty Font 
         Name            =   "Century Gothic"
         Size            =   15.75
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   495
      Left            =   4200
      Style           =   1  'Graphical
      TabIndex        =   15
      Top             =   6960
      Width           =   1215
   End
   Begin MSAdodcLib.Adodc Adodc1 
      Height          =   495
      Left            =   2520
      Top             =   3000
      Width           =   1455
      _ExtentX        =   2566
      _ExtentY        =   873
      ConnectMode     =   0
      CursorLocation  =   3
      IsolationLevel  =   -1
      ConnectionTimeout=   15
      CommandTimeout  =   30
      CursorType      =   3
      LockType        =   3
      CommandType     =   2
      CursorOptions   =   0
      CacheSize       =   50
      MaxRecords      =   0
      BOFAction       =   0
      EOFAction       =   0
      ConnectStringType=   1
      Appearance      =   1
      BackColor       =   -2147483643
      ForeColor       =   -2147483640
      Orientation     =   0
      Enabled         =   -1
      Connect         =   "Provider=Microsoft.Jet.OLEDB.4.0;Data Source=C:\WINDOWS\Desktop\nLIB\db1.mdb;Persist Security Info=False"
      OLEDBString     =   "Provider=Microsoft.Jet.OLEDB.4.0;Data Source=C:\WINDOWS\Desktop\nLIB\db1.mdb;Persist Security Info=False"
      OLEDBFile       =   ""
      DataSourceName  =   ""
      OtherAttributes =   ""
      UserName        =   ""
      Password        =   ""
      RecordSource    =   "studentissue"
      Caption         =   "Adodc1"
      BeginProperty Font {0BE35203-8F91-11CE-9DE3-00AA004BB851} 
         Name            =   "MS Sans Serif"
         Size            =   8.25
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      _Version        =   393216
   End
   Begin VB.ComboBox cmbStudentid 
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   12
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   420
      Left            =   6480
      TabIndex        =   2
      Top             =   2520
      Width           =   1695
   End
   Begin VB.Label Label8 
      BackColor       =   &H8000000E&
      DataField       =   "ExtraDays"
      DataSource      =   "Adodc1"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   12
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   495
      Left            =   6480
      TabIndex        =   14
      Top             =   5400
      Width           =   1695
   End
   Begin VB.Label Label6 
      BackStyle       =   0  'Transparent
      Caption         =   "Extra Days"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   12
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   495
      Left            =   4560
      TabIndex        =   13
      Top             =   5400
      Width           =   1815
   End
   Begin VB.Label lblTotalfine 
      BackColor       =   &H8000000E&
      DataField       =   "Fine"
      DataSource      =   "Adodc1"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   12
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   495
      Left            =   6480
      TabIndex        =   12
      Top             =   6000
      Width           =   1695
   End
   Begin VB.Label Label4 
      AutoSize        =   -1  'True
      BackStyle       =   0  'Transparent
      Caption         =   "Total Fine"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   12
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   540
      Left            =   4560
      TabIndex        =   11
      Top             =   6000
      Width           =   1770
   End
   Begin VB.Label lblIssuedate 
      BackColor       =   &H8000000E&
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   12
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   495
      Left            =   6480
      TabIndex        =   10
      Top             =   3600
      Width           =   1695
   End
   Begin VB.Label lblReturnedon 
      BackColor       =   &H8000000E&
      DataField       =   "ReturnedOn"
      DataSource      =   "Adodc1"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   12
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   495
      Left            =   6480
      TabIndex        =   9
      Top             =   4800
      Width           =   1695
   End
   Begin VB.Label Label9 
      BackStyle       =   0  'Transparent
      Caption         =   "Returned On"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   12
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   495
      Left            =   4560
      TabIndex        =   8
      Top             =   4800
      Width           =   1815
   End
   Begin VB.Label lblReturningdate 
      BackColor       =   &H8000000E&
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   12
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   495
      Left            =   6480
      TabIndex        =   7
      Top             =   4200
      Width           =   1695
   End
   Begin VB.Label Label7 
      BackStyle       =   0  'Transparent
      Caption         =   "Returning Date"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   12
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   495
      Left            =   4560
      TabIndex        =   6
      Top             =   4200
      Width           =   1815
   End
   Begin VB.Label Label5 
      BackStyle       =   0  'Transparent
      Caption         =   "Issue date"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   12
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   495
      Left            =   4560
      TabIndex        =   5
      Top             =   3600
      Width           =   1815
   End
   Begin VB.Label lblBookid 
      BackColor       =   &H8000000E&
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   12
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   495
      Left            =   6480
      TabIndex        =   4
      Top             =   3000
      Width           =   1695
   End
   Begin VB.Label Label3 
      BackStyle       =   0  'Transparent
      Caption         =   "Book Id"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   12
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   495
      Left            =   4560
      TabIndex        =   3
      Top             =   3000
      Width           =   1815
   End
   Begin VB.Label Label2 
      BackStyle       =   0  'Transparent
      Caption         =   "Student Id"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   12
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   375
      Left            =   4560
      TabIndex        =   1
      Top             =   2520
      Width           =   1815
   End
   Begin VB.Label lblSearch 
      AutoSize        =   -1  'True
      BackColor       =   &H00C0E0FF&
      BackStyle       =   0  'Transparent
      Caption         =   "Student's Book Return Form"
      BeginProperty Font 
         Name            =   "Century Gothic"
         Size            =   24
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00C0E0FF&
      Height          =   585
      Index           =   2
      Left            =   3450
      TabIndex        =   0
      Top             =   1695
      Width           =   6225
   End
End
Attribute VB_Name = "frmStudentReturn"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Option Explicit
Public con As ADODB.Connection
Public rec1 As ADODB.Recordset
Dim abc, pqr As String

Private Sub cmbStudentid_Click()
Dim rdate, rdon As String
If rec1.State Then
rec1.Close
End If

rec1.Open "select * from studentissue where studentid=" & Me.cmbStudentid.Text & " ", con, adOpenDynamic, adLockOptimistic

If rec1.EOF = False Then
    Me.lblBookid.Caption = rec1!bookid
    Me.lblIssuedate.Caption = rec1!issuedate
    Me.lblReturningdate.Caption = rec1!returndate
   
    rec1.Close
    Me.lblReturnedon.Caption = Format(Now, ("dd-mmm-yyyy"))
End If
If rec1.State Then rec1.Close
rec1.Open "select * from finedays", con, adOpenDynamic, adLockOptimistic
If rec1.EOF Then
    MsgBox "Required Values In FineDays Table", vbInformation, "No Data"
    Exit Sub
Else
    abc = rec1!fine
End If
rdon = lblReturnedon.Caption
rdate = lblReturningdate.Caption
'If rdon > rdate Then
    pqr = DateDiff("d", rdate, rdon)
If pqr > 0 Then
    Label8.Caption = pqr
    lblTotalfine.Caption = pqr * abc
Else
    Label8.Caption = 0
    lblTotalfine.Caption = 0
End If
End Sub

Private Sub cmbStudentid_KeyPress(KeyAscii As Integer)
KeyAscii = 0
End Sub

Private Sub Form_Load()
Set con = New ADODB.Connection
con.ConnectionString = "Provider=Microsoft.Jet.OLEDB.4.0;Data Source=C:\WINDOWS\Desktop\nLIB\db1.mdb;Persist Security Info=False"
con.Open
Set rec1 = New ADODB.Recordset
If rec1.State Then rec1.Close
rec1.Open "select studentid from studentissue ", con, adOpenDynamic, adLockOptimistic
If rec1.EOF = False Then
    While Not rec1.EOF
        cmbStudentid.AddItem rec1!studentid
        rec1.MoveNext
    Wend
    rec1.MoveFirst
    cmbStudentid.Text = rec1!studentid
    rec1.Close
End If
Me.cmdSave.Enabled = False
Me.Adodc1.Visible = False
End Sub

Private Sub cmdAdd_Click()
Me.Adodc1.Recordset.AddNew
Me.cmdAdd.Enabled = False
Me.cmdSave.Enabled = True
End Sub

Private Sub cmdBack_Click()
Unload Me
End Sub

Private Sub cmdSave_Click()
If Me.lblBookid.Caption = "" Or Me.lblReturnedon.Caption = "" Then
MsgBox ("Select Student Id")
Exit Sub
Else
'Me.Adodc1.Recordset.Update
con.Execute "update studentissue set returnedon='" & Me.lblReturnedon & "',fine='" & lblTotalfine & "',extradays='" & Label8 & "' where studentid=" & cmbStudentid & ""
MsgBox "Record Saved"
End If

Dim temp As Integer
If rec1.State Then rec1.Close
rec1.Open "select * from bookdetails where bookid=" & Me.lblBookid.Caption & " ", con, adOpenDynamic, adLockOptimistic
temp = rec1.Fields(5).Value + 1
con.Execute "update bookdetails set noofcopies=" & temp & " where bookid=" & Me.lblBookid.Caption & " "





Me.cmdSave.Enabled = False
Me.cmdAdd.Enabled = True
End Sub
