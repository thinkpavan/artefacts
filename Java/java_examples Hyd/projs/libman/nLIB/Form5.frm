VERSION 5.00
Object = "{67397AA1-7FB1-11D0-B148-00A0C922E820}#6.0#0"; "MSADODC.OCX"
Begin VB.Form frmProfessorInfo 
   BackColor       =   &H00400040&
   Caption         =   "Professor Information"
   ClientHeight    =   3195
   ClientLeft      =   60
   ClientTop       =   345
   ClientWidth     =   4680
   LinkTopic       =   "Form5"
   Picture         =   "Form5.frx":0000
   ScaleHeight     =   8595
   ScaleWidth      =   11880
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
      Left            =   8655
      Style           =   1  'Graphical
      TabIndex        =   18
      Top             =   7170
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
      Left            =   7320
      Style           =   1  'Graphical
      TabIndex        =   17
      Top             =   7170
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
      Left            =   6000
      Style           =   1  'Graphical
      TabIndex        =   16
      Top             =   7185
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
      Left            =   4470
      Style           =   1  'Graphical
      TabIndex        =   15
      Top             =   7185
      Width           =   1425
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
      Left            =   3120
      Style           =   1  'Graphical
      TabIndex        =   14
      Top             =   7185
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
      Left            =   1800
      Style           =   1  'Graphical
      TabIndex        =   13
      Top             =   7185
      Width           =   1215
   End
   Begin MSAdodcLib.Adodc Adodc1 
      Height          =   495
      Left            =   120
      Top             =   1800
      Width           =   1575
      _ExtentX        =   2778
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
      RecordSource    =   "professorinfo"
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
   Begin VB.TextBox txtAcademicyear 
      DataField       =   "Year"
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
      Left            =   5160
      MaxLength       =   4
      TabIndex        =   5
      Top             =   6480
      Width           =   1335
   End
   Begin VB.TextBox txtDepartment 
      DataField       =   "Department"
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
      Left            =   5160
      MaxLength       =   20
      TabIndex        =   4
      Top             =   5880
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
      Left            =   5160
      MaxLength       =   40
      MultiLine       =   -1  'True
      ScrollBars      =   2  'Vertical
      TabIndex        =   3
      Top             =   4560
      Width           =   4800
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
      Left            =   5160
      MaxLength       =   15
      TabIndex        =   2
      Top             =   3960
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
      Left            =   5160
      MaxLength       =   15
      TabIndex        =   1
      Top             =   3360
      Width           =   2415
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
      Left            =   5160
      MaxLength       =   15
      TabIndex        =   0
      Top             =   2760
      Width           =   2415
   End
   Begin VB.Label Label7 
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
      Left            =   3000
      TabIndex        =   12
      Top             =   6480
      Width           =   1815
   End
   Begin VB.Label Label6 
      BackStyle       =   0  'Transparent
      Caption         =   "Department"
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
      Left            =   3000
      TabIndex        =   11
      Top             =   5880
      Width           =   1815
   End
   Begin VB.Label Label5 
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
      Left            =   3000
      TabIndex        =   10
      Top             =   4560
      Width           =   1815
   End
   Begin VB.Label Label4 
      BackStyle       =   0  'Transparent
      Caption         =   "Last name"
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
      Left            =   3000
      TabIndex        =   9
      Top             =   3960
      Width           =   1815
   End
   Begin VB.Label Label3 
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
      Left            =   3000
      TabIndex        =   8
      Top             =   3360
      Width           =   1815
   End
   Begin VB.Label Label2 
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
      Left            =   3000
      TabIndex        =   7
      Top             =   2760
      Width           =   1815
   End
   Begin VB.Label lblFirstName 
      AutoSize        =   -1  'True
      BackColor       =   &H00C0E0FF&
      BackStyle       =   0  'Transparent
      Caption         =   "Professor's Information Form"
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
      Left            =   3645
      TabIndex        =   6
      Top             =   1875
      Width           =   4935
   End
End
Attribute VB_Name = "frmProfessorInfo"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Dim cn As ADODB.Connection

Private Sub Form_Load()
Set cn = New ADODB.Connection
cn.Open "Provider=Microsoft.Jet.OLEDB.4.0;Data Source=C:\WINDOWS\Desktop\nLIB\db1.mdb;Persist Security Info=False"
Me.Adodc1.Visible = False
cmdSave.Enabled = False
End Sub

Private Sub cmdAdd_Click()
Me.Adodc1.Recordset.AddNew
cmdAdd.Enabled = False
cmdSave.Enabled = True
Me.cmdPrevious.Enabled = False
Me.cmdNext.Enabled = False
Me.cmdDelete.Enabled = False
Me.txtFirstname.SetFocus
End Sub

Private Sub cmdBack_Click()
Unload Me
frmMain.Show
End Sub

Private Sub cmdDelete_Click()
If Me.txtFirstname.Text = "" Or Me.txtMiddlename.Text = "" Or Me.txtLastname.Text = "" Or Me.txtAddress.Text = "" Or Me.txtDepartment.Text = "" Or Me.txtAcademicyear.Text = "" Then
MsgBox ("No record is present")
Exit Sub
Else
cn.Execute "delete from professorinfo where firstname = '" & txtFirstname.Text & "'"
MsgBox "Record Deleted"
End If
Adodc1.Refresh

End Sub

Private Sub cmdNext_Click()
If Me.Adodc1.Recordset.RecordCount = 0 Then
MsgBox " Database is empty"
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
MsgBox " Database is empty"
Exit Sub
End If
If Me.Adodc1.Recordset.BOF Then
Me.Adodc1.Recordset.MoveLast
Else
Me.Adodc1.Recordset.MovePrevious
End If
End Sub

Private Sub cmdSave_Click()
If Me.txtFirstname.Text = "" Or Me.txtMiddlename.Text = "" Or Me.txtLastname.Text = "" Or Me.txtAddress.Text = "" Or Me.txtDepartment.Text = "" Or Me.txtAcademicyear.Text = "" Then
MsgBox ("Incomplete Record")
Exit Sub
Else
Me.Adodc1.Recordset.Update
End If
cmdSave.Enabled = False
cmdAdd.Enabled = True
Me.cmdPrevious.Enabled = True
Me.cmdNext.Enabled = True
Me.cmdDelete.Enabled = True
End Sub

Private Sub txtAcademicyear_KeyPress(KeyAscii As Integer)
Dim STRVALID As String
STRVALID = "0123456789"
KeyAscii = Asc(UCase(Chr(KeyAscii)))
If KeyAscii > 26 Then
    If InStr(STRVALID, Chr(KeyAscii)) = 0 Then
        KeyAscii = 0
    End If
End If
End Sub

Private Sub txtAddress_KeyPress(KeyAscii As Integer)
If KeyAscii = 13 Then
Me.txtDepartment.SetFocus
End If
End Sub

Private Sub txtDepartment_KeyPress(KeyAscii As Integer)
Dim STRVALID As String
STRVALID = "ABCDEFGHIJKLMNOPQRSTUVWXYZ "
KeyAscii = Asc(UCase(Chr(KeyAscii)))
If KeyAscii > 26 Then
    If InStr(STRVALID, Chr(KeyAscii)) = 0 Then
        KeyAscii = 0
    End If
End If
If KeyAscii = 13 Then
Me.txtAcademicyear.SetFocus
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
STRVALID = "ABCDEFGHIJKLMNOPQRSTUVWXYZ'"
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