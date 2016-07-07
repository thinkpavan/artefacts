VERSION 5.00
Object = "{67397AA1-7FB1-11D0-B148-00A0C922E820}#6.0#0"; "MSADODC.OCX"
Begin VB.Form frmStudentIssue 
   BackColor       =   &H00400040&
   Caption         =   "Student Issue"
   ClientHeight    =   3195
   ClientLeft      =   60
   ClientTop       =   345
   ClientWidth     =   4680
   LinkTopic       =   "Form7"
   Picture         =   "Form7.frx":0000
   ScaleHeight     =   3195
   ScaleWidth      =   4680
   StartUpPosition =   3  'Windows Default
   WindowState     =   2  'Maximized
   Begin VB.CommandButton cmdBack 
      BackColor       =   &H00E0E0E0&
      Caption         =   "&Back"
      BeginProperty Font 
         Name            =   "Arial"
         Size            =   12
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   495
      Left            =   7440
      Style           =   1  'Graphical
      TabIndex        =   16
      Top             =   6690
      Width           =   1215
   End
   Begin VB.CommandButton cmdSave 
      BackColor       =   &H00E0E0E0&
      Caption         =   "&Save"
      BeginProperty Font 
         Name            =   "Arial"
         Size            =   12
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   495
      Left            =   5925
      Style           =   1  'Graphical
      TabIndex        =   5
      Top             =   6705
      Width           =   1215
   End
   Begin VB.CommandButton cmdAdd 
      BackColor       =   &H00E0E0E0&
      Caption         =   "&Add"
      BeginProperty Font 
         Name            =   "Arial"
         Size            =   12
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   495
      Left            =   4440
      Style           =   1  'Graphical
      TabIndex        =   1
      Top             =   6705
      Width           =   1215
   End
   Begin VB.CommandButton cmdBookid 
      BackColor       =   &H00E0E0E0&
      Caption         =   "&View"
      BeginProperty Font 
         Name            =   "Arial"
         Size            =   12
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   420
      Left            =   7875
      Style           =   1  'Graphical
      TabIndex        =   4
      Top             =   3525
      Width           =   795
   End
   Begin VB.TextBox Text1 
      DataField       =   "BookId"
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
      Left            =   6255
      TabIndex        =   3
      Top             =   3480
      Width           =   1560
   End
   Begin MSAdodcLib.Adodc Adodc1 
      Height          =   495
      Left            =   2280
      Top             =   2880
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
   Begin VB.TextBox txtStudentid 
      BackColor       =   &H80000014&
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
      Left            =   6240
      TabIndex        =   2
      Top             =   2880
      Width           =   1575
   End
   Begin VB.Label student_id 
      AutoSize        =   -1  'True
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
      Height          =   540
      Left            =   4440
      TabIndex        =   15
      Top             =   2880
      Width           =   1605
   End
   Begin VB.Label book_id 
      AutoSize        =   -1  'True
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
      Height          =   540
      Left            =   4440
      TabIndex        =   14
      Top             =   3480
      Width           =   1635
   End
   Begin VB.Label booktitle 
      AutoSize        =   -1  'True
      Caption         =   "Book Title"
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
      Left            =   4440
      TabIndex        =   13
      Top             =   4080
      Width           =   1650
   End
   Begin VB.Label author_name 
      AutoSize        =   -1  'True
      Caption         =   "Author Name"
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
      Left            =   4440
      TabIndex        =   12
      Top             =   4680
      Width           =   1650
   End
   Begin VB.Label Issue_date 
      AutoSize        =   -1  'True
      Caption         =   "Issue Date"
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
      Left            =   4440
      TabIndex        =   11
      Top             =   5280
      Width           =   1650
   End
   Begin VB.Label lblAuthorname 
      BackColor       =   &H80000014&
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
      Left            =   6240
      TabIndex        =   10
      Top             =   4680
      Width           =   2415
   End
   Begin VB.Label lblBooktitle 
      BackColor       =   &H80000014&
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
      Left            =   6240
      TabIndex        =   9
      Top             =   4080
      Width           =   2415
   End
   Begin VB.Label Label4 
      AutoSize        =   -1  'True
      Caption         =   "Return Date"
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
      Left            =   4440
      TabIndex        =   8
      Top             =   5880
      Width           =   1665
   End
   Begin VB.Label lblIssuedate 
      BackColor       =   &H80000014&
      DataField       =   "IssueDate"
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
      Left            =   6240
      TabIndex        =   7
      Top             =   5280
      Width           =   1575
   End
   Begin VB.Label lblReturndate 
      BackColor       =   &H80000014&
      DataField       =   "ReturnDate"
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
      Left            =   6240
      TabIndex        =   6
      Top             =   5880
      Width           =   1575
   End
   Begin VB.Label lblSearch 
      AutoSize        =   -1  'True
      BackColor       =   &H00C0E0FF&
      BackStyle       =   0  'Transparent
      Caption         =   "Student's Issue Detail Form"
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
      Left            =   3360
      TabIndex        =   0
      Top             =   1875
      Width           =   6030
   End
End
Attribute VB_Name = "frmStudentIssue"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Option Explicit
Public con As ADODB.Connection
Public rec1, rec As ADODB.Recordset
Dim abc As String

Private Sub cmdBookid_Click()

If rec1.State Then
rec1.Close
End If
rec1.Open "select * from bookdetails where bookid=" & Me.Text1.Text & " ", con, adOpenDynamic, adLockOptimistic

If rec1.EOF = False Then
    Me.lblBooktitle.Caption = rec1!booktitle
    Me.lblAuthorname.Caption = rec1!authorname

        If rec1.Fields(5).Value = 0 Then
            MsgBox "Books are not available"
            Me.cmdSave.Enabled = False
            Me.cmdAdd.Enabled = True
        End If

    rec1.Close
    If rec1.State Then rec1.Close
    rec1.Open "select * from finedays", con, adOpenDynamic, adLockOptimistic
    If rec1.EOF Then
        MsgBox "Enter the fine & no. of days in Fine/Day form", vbInformation, "Data Required"
        Exit Sub
    Else
        abc = rec1!days
    End If
    
    Me.lblIssuedate.Caption = Format(Now, ("dd-mmm-yyyy"))
    
    Me.lblReturndate.Caption = Format(Now + abc, ("dd-mmm-yyyy"))
End If


End Sub

Private Sub cmbBookid_KeyPress(KeyAscii As Integer)
KeyAscii = 0
End Sub




Private Sub cmdAdd_Click()
Me.cmdAdd.Enabled = False
Me.cmdSave.Enabled = True
Me.Adodc1.Recordset.AddNew
End Sub

Private Sub cmdBack_Click()
Unload Me
frmMain.Show
End Sub

Private Sub cmdSave_Click()
If Me.txtStudentid.Text = "" Or Me.Text1.Text = "" Or Me.lblAuthorname.Caption = "" Then
MsgBox ("Incomplete Information")
Exit Sub
Else
Me.Adodc1.Recordset.Update
End If
Me.cmdSave.Enabled = False
Me.cmdAdd.Enabled = True




Dim temp As Integer
If rec1.State Then
rec1.Close
End If
rec1.Open "select * from bookdetails where bookid=" & Me.Text1.Text & " ", con, adOpenDynamic, adLockOptimistic
If rec1.Fields(5).Value = 1 Then
MsgBox "It was last copy"
End If

temp = rec1.Fields(5).Value - 1
con.Execute "update bookdetails set noofcopies=" & temp & " where bookid=" & Me.Text1.Text & " "


End Sub

Private Sub Form_Load()
Me.cmdBookid.Enabled = False
Set con = New ADODB.Connection
con.ConnectionString = " Provider=Microsoft.Jet.OLEDB.4.0;Data Source=C:\WINDOWS\Desktop\nLIB\db1.mdb;Persist Security Info=False "
con.Open
Set rec1 = New ADODB.Recordset
If rec1.State Then rec1.Close
rec1.Open "select bookid from bookdetails", con, adOpenDynamic, adLockOptimistic
Me.cmdSave.Enabled = False
Me.Adodc1.Visible = False
End Sub





Private Sub Text1_Change()
Me.cmdBookid.Enabled = True
If Me.Text1.Text = "" Then
Me.cmdBookid.Enabled = False
End If
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
End Sub
