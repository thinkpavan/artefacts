VERSION 5.00
Object = "{67397AA1-7FB1-11D0-B148-00A0C922E820}#6.0#0"; "MSADODC.OCX"
Begin VB.Form frmStudentInfo 
   BackColor       =   &H00400040&
   Caption         =   "Student Information"
   ClientHeight    =   3195
   ClientLeft      =   60
   ClientTop       =   345
   ClientWidth     =   4680
   LinkTopic       =   "Form4"
   Picture         =   "Form4.frx":0000
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
      Left            =   9360
      Style           =   1  'Graphical
      TabIndex        =   23
      Top             =   7320
      Width           =   1215
   End
   Begin VB.CommandButton cmdDelete 
      BackColor       =   &H00E0E0E0&
      Caption         =   "&Delete"
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
      Left            =   8100
      Style           =   1  'Graphical
      TabIndex        =   22
      Top             =   7320
      Width           =   1215
   End
   Begin VB.CommandButton cmdNext 
      BackColor       =   &H00E0E0E0&
      Caption         =   "&Next"
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
      Left            =   6795
      Style           =   1  'Graphical
      TabIndex        =   21
      Top             =   7320
      Width           =   1215
   End
   Begin VB.CommandButton cmdPrevious 
      BackColor       =   &H00E0E0E0&
      Caption         =   "&Previous"
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
      Left            =   5325
      Style           =   1  'Graphical
      TabIndex        =   20
      Top             =   7320
      Width           =   1380
   End
   Begin VB.CommandButton cmdSearch 
      BackColor       =   &H00E0E0E0&
      Caption         =   "S&earch"
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
      Left            =   4020
      Style           =   1  'Graphical
      TabIndex        =   19
      Top             =   7320
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
      Left            =   2685
      Style           =   1  'Graphical
      TabIndex        =   18
      Top             =   7320
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
      Left            =   1410
      Style           =   1  'Graphical
      TabIndex        =   17
      Top             =   7320
      Width           =   1215
   End
   Begin MSAdodcLib.Adodc Adodc1 
      Height          =   495
      Left            =   120
      Top             =   1680
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
      RecordSource    =   "studentinfo"
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
   Begin VB.TextBox txtFirstname 
      DataField       =   "FirstName"
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
      Left            =   4800
      MaxLength       =   15
      TabIndex        =   1
      Top             =   2880
      Width           =   2415
   End
   Begin VB.TextBox txtMiddlename 
      DataField       =   "MiddleName"
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
      Left            =   4800
      MaxLength       =   15
      TabIndex        =   2
      Top             =   3480
      Width           =   2415
   End
   Begin VB.TextBox txtLastname 
      DataField       =   "LastName"
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
      Left            =   4800
      MaxLength       =   15
      TabIndex        =   3
      Top             =   4080
      Width           =   2415
   End
   Begin VB.TextBox txtAddress 
      DataField       =   "Address"
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
      Height          =   1215
      Left            =   4800
      MaxLength       =   60
      MultiLine       =   -1  'True
      ScrollBars      =   2  'Vertical
      TabIndex        =   4
      Top             =   4680
      Width           =   5265
   End
   Begin VB.TextBox txtStudentid 
      DataField       =   "StudentId"
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
      Left            =   4800
      MaxLength       =   4
      TabIndex        =   0
      Top             =   2280
      Width           =   2415
   End
   Begin VB.TextBox txtClass 
      DataField       =   "Class"
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
      Height          =   480
      Left            =   6480
      MaxLength       =   5
      TabIndex        =   5
      Top             =   6000
      Width           =   1455
   End
   Begin VB.ComboBox cmbStream 
      DataField       =   "Stream"
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
      Height          =   420
      Left            =   4800
      TabIndex        =   6
      Top             =   6000
      Width           =   1455
   End
   Begin VB.Label Label8 
      BackStyle       =   0  'Transparent
      Caption         =   "Academic Year"
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
      Left            =   2880
      TabIndex        =   16
      Top             =   6720
      Width           =   1695
   End
   Begin VB.Label Label7 
      BackStyle       =   0  'Transparent
      Caption         =   "Class"
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
      Left            =   2880
      TabIndex        =   15
      Top             =   6000
      Width           =   1695
   End
   Begin VB.Label Label6 
      BackStyle       =   0  'Transparent
      Caption         =   "Address"
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
      Left            =   2880
      TabIndex        =   14
      Top             =   4680
      Width           =   1695
   End
   Begin VB.Label Label5 
      BackStyle       =   0  'Transparent
      Caption         =   "Last Name"
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
      Left            =   2880
      TabIndex        =   13
      Top             =   4080
      Width           =   1695
   End
   Begin VB.Label Label4 
      BackStyle       =   0  'Transparent
      Caption         =   "Middle Name"
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
      Left            =   2880
      TabIndex        =   12
      Top             =   3480
      Width           =   1695
   End
   Begin VB.Label Label3 
      BackStyle       =   0  'Transparent
      Caption         =   "First Name"
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
      Left            =   2880
      TabIndex        =   11
      Top             =   2880
      Width           =   1695
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
      Height          =   495
      Left            =   2880
      TabIndex        =   10
      Top             =   2280
      Width           =   1695
   End
   Begin VB.Label lblStudentId 
      AutoSize        =   -1  'True
      BackColor       =   &H00C0E0FF&
      BackStyle       =   0  'Transparent
      Caption         =   "Student's Information Form"
      BeginProperty Font 
         Name            =   "Century Gothic"
         Size            =   18
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00C0E0FF&
      Height          =   450
      Index           =   0
      Left            =   3735
      TabIndex        =   9
      Top             =   1680
      Width           =   4725
   End
   Begin VB.Label lblAcademicyear 
      BackColor       =   &H8000000E&
      DataField       =   "AcademicYear"
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
      Left            =   4800
      TabIndex        =   8
      Top             =   6720
      Width           =   1455
   End
   Begin VB.Label lblAcademicyear1 
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
      Top             =   6720
      Width           =   1455
   End
End
Attribute VB_Name = "frmStudentInfo"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Dim cn As ADODB.Connection
Dim rec As ADODB.Recordset

Private Sub cmbStream_KeyPress(KeyAscii As Integer)
KeyAscii = 0
End Sub

Private Sub Form_Load()
cmdSave.Enabled = False
Me.Adodc1.Visible = False

Set cn = New ADODB.Connection
cn.Open "Provider=Microsoft.Jet.OLEDB.4.0;Persist Security Info=False;Data Source=\windows\desktop\nLIB\db1.mdb"
Set rec = New ADODB.Recordset
Set rec.ActiveConnection = cn

Set con = New ADODB.Connection
con.ConnectionString = "Provider=Microsoft.Jet.OLEDB.4.0;Data Source=C:\WINDOWS\Desktop\nLIB\db1.mdb;Persist Security Info=False"
con.Open
Set rec2 = New ADODB.Recordset
If rec2.State Then rec2.Close

rec2.Open "select stream from stream", con, adOpenDynamic, adLockOptimistic
If rec2.EOF = False Then
    While Not rec2.EOF
        cmbStream.AddItem rec2!Stream
        rec2.MoveNext
    Wend
    rec2.MoveFirst
    cmbStream.Text = rec2!Stream
    rec2.Close
End If
End Sub


Private Sub cmdAdd_Click()
Adodc1.Recordset.AddNew
Me.lblAcademicyear1.Caption = ""
Me.txtStudentid.SetFocus
cmdSave.Enabled = True
cmdAdd.Enabled = False
Me.cmdDelete.Enabled = False
Me.cmdNext.Enabled = False
Me.cmdPrevious.Enabled = False
End Sub

Private Sub cmdBack_Click()
Unload Me
frmMain.Show
End Sub

Private Sub cmdDelete_Click()

If Me.txtFirstname.Text = "" Or Me.txtMiddlename.Text = "" Or Me.txtLastname.Text = "" Or Me.txtAddress.Text = "" Or Me.txtStudentid.Text = "" Or Me.cmbStream.Text = "" Or Me.txtClass.Text = "" Then
MsgBox ("No record is present")
Exit Sub
Else
cn.Execute "delete from studentinfo where studentid = " & txtStudentid.Text & ""
MsgBox "Record Deleted"
End If
Adodc1.Refresh

End Sub

Private Sub cmdNext_Click()
If Me.Adodc1.Recordset.RecordCount = 0 Then
MsgBox "Database is empty"
Exit Sub
End If
If Me.Adodc1.Recordset.EOF Then
Me.Adodc1.Recordset.MoveFirst
Else
Me.Adodc1.Recordset.MoveNext
End If
End Sub

Private Sub cmdPrevious_Click()
If Me.Adodc1.Recordset.RecordCount = 0 Then
MsgBox "Database is empty"
Exit Sub
End If
If Me.Adodc1.Recordset.BOF Then
Me.Adodc1.Recordset.MoveLast
Else
Me.Adodc1.Recordset.MovePrevious
End If
End Sub

Private Sub cmdSave_Click()

On Error GoTo message
If Me.txtFirstname.Text = "" Or Me.txtMiddlename.Text = "" Or Me.txtLastname.Text = "" Or Me.txtStudentid.Text = "" Or Me.txtAddress.Text = "" Or Me.cmbStream.Text = "" Or Me.txtClass.Text = "" Then
MsgBox ("Incomplete record")
Exit Sub
Else
Me.Adodc1.Recordset.Update
MsgBox ("Record Saved")
End If
message:
If Err Then
MsgBox ("Student Id already exists")
Exit Sub
End If
cmdSave.Enabled = False
cmdAdd.Enabled = True
Me.cmdDelete.Enabled = True
Me.cmdNext.Enabled = True
Me.cmdPrevious.Enabled = True
End Sub

Private Sub cmdSearch_Click()
Set rec = New ADODB.Recordset
Dim ans As String
ans = InputBox("Enter the Student Id")
rec.Open "select * from studentinfo", cn, adOpenDynamic
rec.Find "studentid=" & ans & ""
If ans = "" Then
Exit Sub
End If
On Error GoTo message
If ans <> "" Then
Me.txtStudentid.Text = rec.Fields(0)
Me.txtFirstname.Text = rec.Fields(1)
Me.txtMiddlename.Text = rec.Fields(2)
Me.txtLastname.Text = rec.Fields(3)
Me.txtAddress.Text = rec.Fields(4)
Me.cmbStream.Text = rec.Fields(5)
Me.txtClass.Text = rec.Fields(6)
End If
message:
If Err Then
MsgBox "Record not found"
End If
End Sub

Private Sub txtClass_KeyPress(KeyAscii As Integer)
Dim STRVALID As String
STRVALID = "ABCDEFGHIJKLMNOPQRSTUVWXYZ'"
KeyAscii = Asc(UCase(Chr(KeyAscii)))
If KeyAscii > 26 Then
    If InStr(STRVALID, Chr(KeyAscii)) = 0 Then
        KeyAscii = 0
    End If
End If
End Sub

Private Sub txtFirstname_KeyPress(KeyAscii As Integer)

Dim STRVALID As String
STRVALID = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
KeyAscii = Asc(UCase(Chr(KeyAscii)))
If KeyAscii > 26 Then
    If InStr(STRVALID, Chr(KeyAscii)) = 0 Then
        KeyAscii = 0
    End If
End If

If KeyAscii = 13 Then
Me.txtMiddlename.SetFocus
End If
End Sub


Private Sub txtLastname_keypress(KeyAscii As Integer)
Dim STRVALID As String
STRVALID = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
KeyAscii = Asc(UCase(Chr(KeyAscii)))
If KeyAscii > 26 Then
   If InStr(STRVALID, Chr(KeyAscii)) = 0 Then
   KeyAscii = 0
    End If
 End If
If KeyAscii = 13 Then
Me.txtAddress.SetFocus
End If
End Sub

Private Sub txtMiddlename_keypress(KeyAscii As Integer)
Dim STRVALID As String
STRVALID = "ABCDEFGHIJKLMNOPQRSTUVWXYZ'"
KeyAscii = Asc(UCase(Chr(KeyAscii)))
If KeyAscii > 26 Then
    If InStr(STRVALID, Chr(KeyAscii)) = 0 Then
        KeyAscii = 0
    End If
End If
If KeyAscii = 13 Then
Me.txtLastname.SetFocus
End If
End Sub

Private Sub txtStudentid_Change()
Me.lblAcademicyear.Caption = 2002
Me.lblAcademicyear1.Caption = 2003
End Sub

Private Sub txtStudentid_KeyPress(KeyAscii As Integer)
Dim STRVALID As String
STRVALID = "0123456789"
KeyAscii = Asc(UCase(Chr(KeyAscii)))
If KeyAscii > 26 Then
    If InStr(STRVALID, Chr(KeyAscii)) = 0 Then
        KeyAscii = 0
    End If
End If
If KeyAscii = 13 Then
Me.txtFirstname.SetFocus
End If
End Sub
